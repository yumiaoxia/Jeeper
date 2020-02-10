package com.itsherman.web.javagenerator.dao.model;

public class ClassParameterizedType extends ParameterizedType {

    private Class classType;

    public ClassParameterizedType(ParameterizedEnum parameterizedEnum,Class classType) {
        super(parameterizedEnum);
        this.classType = classType;
    }

    public Class getClassType() {
        return classType;
    }

    public void setClassType(Class classType) {
        this.classType = classType;
    }
}
