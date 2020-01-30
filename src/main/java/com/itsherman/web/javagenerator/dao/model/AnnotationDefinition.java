package com.itsherman.web.javagenerator.dao.model;

import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.List;

/**
 * 类注解
 */
public class AnnotationDefinition extends ModelDefinition {

    private Class<? extends Annotation> annotationType;
    private List<AnnotationAttribute> annotationAttributes = new ArrayList<>();

    public AnnotationDefinition(String signature, Class<? extends Annotation> annotationType) {
        super(signature);
        this.annotationType = annotationType;
    }

    public Class<? extends Annotation> getAnnotationType() {
        return annotationType;
    }

    public void setAnnotationType(Class<? extends Annotation> annotationType) {
        this.annotationType = annotationType;
    }

    public List<AnnotationAttribute> getAnnotationAttributes() {
        return annotationAttributes;
    }

    public void setAnnotationAttributes(List<AnnotationAttribute> annotationAttributes) {
        this.annotationAttributes = annotationAttributes;
    }
}
