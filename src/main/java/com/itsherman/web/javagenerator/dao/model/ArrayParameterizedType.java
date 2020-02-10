package com.itsherman.web.javagenerator.dao.model;

public class ArrayParameterizedType extends ParameterizedType {

    private ParameterizedType parameterizedType;

    public ArrayParameterizedType(ParameterizedEnum parameterizedEnum,ParameterizedType parameterizedType) {
        super(parameterizedEnum);
        this.parameterizedType = parameterizedType;
    }

    public ParameterizedType getParameterizedType() {
        return parameterizedType;
    }

    public void setParameterizedType(ParameterizedType parameterizedType) {
        this.parameterizedType = parameterizedType;
    }
}
