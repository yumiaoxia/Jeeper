package com.itsherman.web.javagenerator.service.vo;

import javax.lang.model.element.Modifier;

public class TypeVariableParameterVO extends ParameterVO {

    private String variable;

    public TypeVariableParameterVO(AbstractSignatureVO parentVO, String parameterName, Modifier... modifiers) {
        super(parentVO, parameterName, modifiers);
    }

    public String getVariable() {
        return variable;
    }

    public void setVariable(String variable) {
        this.variable = variable;
    }
}
