package com.itsherman.web.javagenerator.service.vo;

import javax.lang.model.element.Modifier;

public class ParameterizedParameterVO extends ParameterVO {

    private String rawTypeName;

    public ParameterizedParameterVO(AbstractSignatureVO parentVO, String parameterName, Modifier... modifiers) {
        super(parentVO, parameterName, modifiers);
    }
}
