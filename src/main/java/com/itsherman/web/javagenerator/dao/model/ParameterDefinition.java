package com.itsherman.web.javagenerator.dao.model;

import javax.lang.model.element.Modifier;
import java.util.Collections;
import java.util.List;

public abstract class ParameterDefinition extends ModelDefinition {

    private String parameterName;
    private Modifier[] modifiers;
    private List<AnnotationDefinition> annotationDefinitions = Collections.emptyList();

    public ParameterDefinition(String signature, String parameterName,Modifier... modifiers) {
        super(signature);
        this.parameterName = parameterName;
        this.modifiers = modifiers;
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

    public List<AnnotationDefinition> getAnnotationDefinitions() {
        return annotationDefinitions;
    }

    public void setAnnotationDefinitions(List<AnnotationDefinition> annotationDefinitions) {
        this.annotationDefinitions = annotationDefinitions;
    }


    public enum ParameterEnum{
        ARRAY,
        PARAMETERIZED,
        CLASS,
        TYPE_VARIABLE,
        WILDCARD
    }
}
