package com.itsherman.web.javagenerator.dao.model;

public class ArrayTypeDefinition {

    private TypeDefinition typeDefinition;

    public ArrayTypeDefinition(TypeDefinition typeDefinition) {
        this.typeDefinition = typeDefinition;
    }

    public TypeDefinition getTypeDefinition() {
        return typeDefinition;
    }

    public void setTypeDefinition(TypeDefinition typeDefinition) {
        this.typeDefinition = typeDefinition;
    }
}
