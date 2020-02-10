package com.itsherman.web.javagenerator.dao.model;

public class ArrayParameterDefinition extends ParameterDefinition {

    private ParameterizedType parameterizedType;

    public ArrayParameterDefinition(String signature, String parameterName, ParameterEnum parameterEnum,ParameterizedType parameterizedType) {
        super(signature, parameterName, parameterEnum);
        this.parameterizedType = parameterizedType;
    }

    public ParameterizedType getParameterizedType() {
        return parameterizedType;
    }

    public void setParameterizedType(ParameterizedType parameterizedType) {
        this.parameterizedType = parameterizedType;
    }
}
