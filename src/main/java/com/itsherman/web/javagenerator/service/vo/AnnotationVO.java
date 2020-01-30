package com.itsherman.web.javagenerator.service.vo;

import java.util.List;

public class AnnotationVO {

    private String typeName;

    private List<AnnotationPropertyVO> annotationProperties;

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public List<AnnotationPropertyVO> getAnnotationProperties() {
        return annotationProperties;
    }

    public void setAnnotationProperties(List<AnnotationPropertyVO> annotationProperties) {
        this.annotationProperties = annotationProperties;
    }
}
