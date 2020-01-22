package com.itsherman.javagenerator.service.vo;

import com.itsherman.javagenerator.web.command.AnnotationPropertyCommand;

import java.util.List;

public class AnnotationVO {

    private String typeName;

    private List<AnnotationPropertyCommand> annotationProperties;

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public List<AnnotationPropertyCommand> getAnnotationProperties() {
        return annotationProperties;
    }

    public void setAnnotationProperties(List<AnnotationPropertyCommand> annotationProperties) {
        this.annotationProperties = annotationProperties;
    }
}
