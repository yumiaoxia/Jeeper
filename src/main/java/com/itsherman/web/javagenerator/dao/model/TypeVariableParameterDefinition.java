package com.itsherman.web.javagenerator.dao.model;

import com.squareup.javapoet.TypeVariableName;

public class TypeVariableParameterDefinition extends ParameterDefinition{

    private String variable;

    public TypeVariableParameterDefinition(String signature, String parameterName, ParameterEnum parameterEnum,String variable) {
        super(signature, parameterName, parameterEnum);
        this.variable = variable;
    }

    public String getVariable() {
        return variable;
    }

    public void setVariable(String variable) {
        this.variable = variable;
    }
}
