package com.itsherman.web.javagenerator.dao.model;

public class ClassParameterDefinition extends ParameterDefinition{

    private Class classType;

    public ClassParameterDefinition(String signature, String parameterName, ParameterEnum parameterEnum,Class classType) {
        super(signature, parameterName, parameterEnum);
        this.classType = classType;
    }

    public Class getClassType() {
        return classType;
    }

    public void setClassType(Class classType) {
        this.classType = classType;
    }
}
