package com.itsherman.web.javagenerator.dao.model;

public class ClassTypeDefinition implements TypeDefinition{

    private String className;

    public ClassTypeDefinition(String className) {
        this.className = className;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }
}
