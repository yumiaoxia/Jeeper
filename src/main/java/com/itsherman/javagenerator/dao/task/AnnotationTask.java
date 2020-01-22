package com.itsherman.javagenerator.dao.task;

import com.itsherman.javagenerator.dao.model.AnnotationAttribute;
import com.itsherman.javagenerator.dao.model.AnnotationDefinition;
import com.squareup.javapoet.AnnotationSpec;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Set;

public class AnnotationTask extends GeneralTask<AnnotationSpec> {

    private static final String FORMAT_ONE = "$S";
    private static final String FORMAT_TWO = "$L";

    private AnnotationDefinition annotationDefinition;

    public AnnotationTask(AnnotationDefinition annotationDefinition) {
        super(annotationDefinition, AnnotationTask.class);
        this.annotationDefinition = annotationDefinition;
    }

    @Override
    public AnnotationSpec run() {
        AnnotationSpec annotationSpec = AnnotationSpec.builder(annotationDefinition.getAnnotationType()).build();
        List<AnnotationAttribute> annotationAttributes = annotationDefinition.getAnnotationAttributes();
        if (!CollectionUtils.isEmpty(annotationAttributes)) {
            for (AnnotationAttribute annotationAttribute : annotationAttributes) {
                String attrName = annotationAttribute.getAttrName();
                Set<Object> attrValues = annotationAttribute.getAttrValue();
                String format = attrValues.size() > 1 ? FORMAT_TWO : FORMAT_ONE;
                for (Object attrValue : attrValues) {
                    // 如果注解属性的值为注解
                    if (attrValue instanceof AnnotationDefinition) {
                        AnnotationDefinition annotationDefinition = (AnnotationDefinition) attrValue;
                        AnnotationTask annotationTask = new AnnotationTask(annotationDefinition);
                        annotationSpec.toBuilder().addMember(attrName, format, annotationTask.run());
                    } else {
                        annotationSpec.toBuilder().addMember(attrName, format, attrValue);
                    }
                }
            }
        }
        log.info("Generate Annotation signed '{}' successfully! ", annotationDefinition.getSignature());
        return annotationSpec;
    }
}
