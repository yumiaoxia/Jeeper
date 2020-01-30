package com.itsherman.web.javagenerator.dao.model;

import java.lang.reflect.Type;

public class ParameterizedParameterDefinition extends ParameterDefinition {

    private Type[] actualTypes;

    private Type ownerType;

    public ParameterizedParameterDefinition(String signature, String parameterName, Class parameterType, Type... actualTypes) {
        super(signature, parameterName, parameterType);
        this.actualTypes = actualTypes;
    }

    public Type[] getActualTypes() {
        return actualTypes;
    }

    public void setActualTypes(Type[] actualTypes) {
        this.actualTypes = actualTypes;
    }

    public Type getOwnerType() {
        return ownerType;
    }

    public void setOwnerType(Type ownerType) {
        this.ownerType = ownerType;
    }
}
