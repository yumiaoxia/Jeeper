package com.itsherman.web.javagenerator.dao.model;

public class TypeVariableDefinition implements TypeDefinition {

    private String variable;

    public TypeVariableDefinition(String variable) {
        this.variable = variable;
    }

    public String getVariable() {
        return variable;
    }

    public void setVariable(String variable) {
        this.variable = variable;
    }
}
