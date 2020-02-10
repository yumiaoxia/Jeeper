package com.itsherman.web.javagenerator.dao.task;

import com.itsherman.web.javagenerator.dao.model.AnnotationDefinition;
import com.itsherman.web.javagenerator.dao.model.FieldDefinition;
import com.squareup.javapoet.FieldSpec;

import javax.lang.model.element.Modifier;
import java.util.List;
import java.util.Set;

public class FieldTask extends GeneralTask<FieldSpec> {

    private FieldDefinition fieldDefinition;

    public FieldTask(FieldDefinition fieldDefinition) {
        super(fieldDefinition, FieldTask.class);
        this.fieldDefinition = fieldDefinition;
    }

    public FieldDefinition getFieldDefinition() {
        return fieldDefinition;
    }

    public void setFieldDefinition(FieldDefinition fieldDefinition) {
        this.fieldDefinition = fieldDefinition;
    }

    @Override
    public FieldSpec run() {
        FieldSpec fieldSpec = FieldSpec.builder(fieldDefinition.getFieldType(), fieldDefinition.getFieldName(), fieldDefinition.getModifiers()).build();
        List<AnnotationDefinition> annotationDefinitions = fieldDefinition.getAnnotationDefinitions();
        for (AnnotationDefinition annotationDefinition : annotationDefinitions) {
            AnnotationTask annotationTask = new AnnotationTask(annotationDefinition);
            fieldSpec.toBuilder().addAnnotation(annotationTask.run());
        }
        return fieldSpec;
    }
}
