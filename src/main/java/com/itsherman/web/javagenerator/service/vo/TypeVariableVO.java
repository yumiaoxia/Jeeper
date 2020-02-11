package com.itsherman.web.javagenerator.service.vo;

import javax.lang.model.element.Modifier;

public class TypeVariableVO implements TypeVO {

    private String variable;

    public TypeVariableVO(String variable) {
        this.variable = variable;
    }

    public String getVariable() {
        return variable;
    }

    public void setVariable(String variable) {
        this.variable = variable;
    }
}
