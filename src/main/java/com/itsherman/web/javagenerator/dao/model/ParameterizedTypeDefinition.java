package com.itsherman.web.javagenerator.dao.model;

public class ParameterizedTypeDefinition implements TypeDefinition {

    private Class rawType;

    private TypeDefinition[] typeArguments;

    public ParameterizedTypeDefinition(Class rawType, TypeDefinition[] typeArguments) {
        this.rawType = rawType;
        this.typeArguments = typeArguments;
    }

    public TypeDefinition[] getTypeArguments() {
        return typeArguments;
    }

    public void setTypeArguments(TypeDefinition[] typeArguments) {
        this.typeArguments = typeArguments;
    }

    public Class getRawType() {
        return rawType;
    }

    public void setRawType(Class rawType) {
        this.rawType = rawType;
    }
}
