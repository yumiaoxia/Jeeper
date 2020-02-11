package com.itsherman.web.javagenerator.dao.model;

public class ParameterizedTypeDefinition {

    private String rawTypeName;

    private TypeDefinition[] typeArguments;

    public ParameterizedTypeDefinition(String rawTypeName, TypeDefinition[] typeArguments) {
        this.rawTypeName = rawTypeName;
        this.typeArguments = typeArguments;
    }

    public TypeDefinition[] getTypeArguments() {
        return typeArguments;
    }

    public void setTypeArguments(TypeDefinition[] typeArguments) {
        this.typeArguments = typeArguments;
    }

    public String getRawTypeName() {
        return rawTypeName;
    }

    public void setRawTypeName(String rawTypeName) {
        this.rawTypeName = rawTypeName;
    }


}
