package com.itsherman.web.javagenerator.dao.model;

import java.lang.reflect.Type;

public class ParameterizedParameterDefinition extends ParameterDefinition {

    private Class rawType;

    private ParameterizedType[] parameterizedTypes;

    public ParameterizedParameterDefinition(String signature, String parameterName, ParameterEnum parameterType, Class rawType, ParameterizedType[] parameterizedTypes) {
        super(signature, parameterName, parameterType);
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
