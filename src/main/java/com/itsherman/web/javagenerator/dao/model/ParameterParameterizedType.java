package com.itsherman.web.javagenerator.dao.model;

public class ParameterParameterizedType extends ParameterizedType{

    private Class rawType;

    private ParameterizedType[] parameterizedTypes;

    public ParameterParameterizedType(ParameterizedEnum parameterizedEnum, Class rawType, ParameterizedType... parameterizedTypes) {
        super(parameterizedEnum);
        this.rawType = rawType;
        this.parameterizedTypes = parameterizedTypes;
    }

    public Class getRawType() {
        return rawType;
    }

    public void setRawType(Class rawType) {
        this.rawType = rawType;
    }

    public ParameterizedType[] getParameterizedTypes() {
        return parameterizedTypes;
    }

    public void setParameterizedTypes(ParameterizedType[] parameterizedTypes) {
        this.parameterizedTypes = parameterizedTypes;
    }
}
