package com.itsherman.web.javagenerator.service.vo;

public class ParameterizedTypeVO implements TypeVO {

    private String rawTypeName;

    private TypeVO[] typeVOS;

    public ParameterizedTypeVO(String rawTypeName, TypeVO[] typeVOS) {
        this.rawTypeName = rawTypeName;
        this.typeVOS = typeVOS;
    }

    public String getRawTypeName() {
        return rawTypeName;
    }

    public void setRawTypeName(String rawTypeName) {
        this.rawTypeName = rawTypeName;
    }

    public TypeVO[] getTypeVOS() {
        return typeVOS;
    }

    public void setTypeVOS(TypeVO[] typeVOS) {
        this.typeVOS = typeVOS;
    }
}
