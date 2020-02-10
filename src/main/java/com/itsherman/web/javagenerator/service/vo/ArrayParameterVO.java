package com.itsherman.web.javagenerator.service.vo;

import javax.lang.model.element.Modifier;

public class ArrayParameterVO extends ParameterVO{

    private ParameterVO contentType;

    public ArrayParameterVO(AbstractSignatureVO parentVO, String parameterName, Modifier... modifiers) {
        super(parentVO, parameterName, modifiers);
    }

    public ParameterVO getContentType() {
        return contentType;
    }

    public void setContentType(ParameterVO contentType) {
        this.contentType = contentType;
    }
}
