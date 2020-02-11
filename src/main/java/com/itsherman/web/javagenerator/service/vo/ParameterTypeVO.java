package com.itsherman.web.javagenerator.service.vo;

import javax.lang.model.element.Modifier;

public class ParameterTypeVO<T extends TypeVO> extends ParameterVO{

    private T t;

    public ParameterTypeVO(T t,AbstractSignatureVO parentVO, String parameterName, Modifier... modifiers) {
        super(parentVO, parameterName, modifiers);
        this.t = t;
    }

    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }
}
