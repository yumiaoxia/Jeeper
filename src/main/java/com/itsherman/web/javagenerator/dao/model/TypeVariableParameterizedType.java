package com.itsherman.web.javagenerator.dao.model;

public class TypeVariableParameterizedType extends ParameterizedType {

    private String variable;

    public TypeVariableParameterizedType(ParameterizedEnum parameterizedEnum,String variable) {
        super(parameterizedEnum);
        this.variable = variable;
    }

    public String getVariable() {
        return variable;
    }

    public void setVariable(String variable) {
        this.variable = variable;
    }
}
