package com.itsherman.web.javagenerator.service.vo;

import javax.lang.model.element.Modifier;

public class ArrayTypeVO implements TypeVO{

    private TypeVO contentType;

    public ArrayTypeVO(TypeVO contentType) {
        this.contentType = contentType;
    }

    public TypeVO getContentType() {
        return contentType;
    }

    public void setContentType(TypeVO contentType) {
        this.contentType = contentType;
    }
}
