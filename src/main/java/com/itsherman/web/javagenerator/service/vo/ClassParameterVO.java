package com.itsherman.web.javagenerator.service.vo;

import javax.lang.model.element.Modifier;

public class ClassParameterVO extends ParameterVO{

    private String className;

    public ClassParameterVO(AbstractSignatureVO parentVO, String parameterName, Modifier... modifiers) {
        super(parentVO, parameterName, modifiers);
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }
}
