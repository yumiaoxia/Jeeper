package com.itsherman.javagenerator.dao.model;

import javax.lang.model.element.Modifier;
import java.util.Collections;
import java.util.List;

public abstract class ParameterDefinition extends ModelDefinition {

    private String parameterName;
    private Modifier[] modifiers = new Modifier[]{};
    private Class parameterType;
    private List<AnnotationDefinition> annotationDefinitions = Collections.emptyList();

    public ParameterDefinition(String signature, String parameterName, Class parameterType) {
        super(signature);
        this.parameterName = parameterName;
        this.parameterType = parameterType;
    }

    public String getParameterName() {
        return parameterName;
    }

    public void setParameterName(String parameterName) {
        this.parameterName = parameterName;
    }

    public Modifier[] getModifiers() {
        return modifiers;
    }

    public void setModifiers(Modifier[] modifiers) {
        this.modifiers = modifiers;
    }

    public Class getParameterType() {
        return parameterType;
    }

    public void setParameterType(Class parameterType) {
        this.parameterType = parameterType;
    }

    public List<AnnotationDefinition> getAnnotationDefinitions() {
        return annotationDefinitions;
    }

    public void setAnnotationDefinitions(List<AnnotationDefinition> annotationDefinitions) {
        this.annotationDefinitions = annotationDefinitions;
    }
}
