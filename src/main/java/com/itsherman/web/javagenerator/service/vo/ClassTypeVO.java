package com.itsherman.web.javagenerator.service.vo;

import javax.lang.model.element.Modifier;

public class ClassTypeVO implements TypeVO{

    private String className;

    public ClassTypeVO(String className) {
        this.className = className;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }
}
