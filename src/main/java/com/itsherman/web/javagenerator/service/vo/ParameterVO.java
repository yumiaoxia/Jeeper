package com.itsherman.web.javagenerator.service.vo;

import javax.lang.model.element.Modifier;

public class ParameterVO<T extends TypeVO> extends AbstractParameterVO {

    private T typeVO;

    public ParameterVO(T typeVO, AbstractSignatureVO parentVO, String parameterName, Modifier... modifiers) {
        super(parentVO, parameterName, modifiers);
        this.typeVO = typeVO;
    }

    public T getTypeVO() {
        return typeVO;
    }

    public void setTypeVO(T typeVO) {
        this.typeVO = typeVO;
    }
}
