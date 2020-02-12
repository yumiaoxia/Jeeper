package com.itsherman.web.javagenerator.dao.model;

public class ClassTypeDefinition implements TypeDefinition{

    private Class classType;

    public ClassTypeDefinition(Class classType) {
        this.classType = classType;
    }

    public Class getClassType() {
        return classType;
    }

    public void setClassType(Class classType) {
        this.classType = classType;
    }
}
