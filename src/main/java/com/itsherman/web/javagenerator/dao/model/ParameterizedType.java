package com.itsherman.web.javagenerator.dao.model;

public abstract class ParameterizedType {

    private ParameterizedEnum parameterizedEnum;

    public ParameterizedType(ParameterizedEnum parameterizedEnum) {
        this.parameterizedEnum = parameterizedEnum;
    }

    public ParameterizedEnum getParameterizedEnum() {
        return parameterizedEnum;
    }

    public void setParameterizedEnum(ParameterizedEnum parameterizedEnum) {
        this.parameterizedEnum = parameterizedEnum;
    }

    public enum ParameterizedEnum{
        ARRAY,
        PARAMETERIZED,
        CLASS,
        TYPE_VARIABLE,
        WILDCARD
    }


}
