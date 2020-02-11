package com.itsherman.web.javagenerator.service.vo;

import com.itsherman.web.javagenerator.enums.WildcardEnum;

public class WildcardTypeVO implements TypeVO {

    private WildcardEnum wildcardEnum;

    private String boundClassName;

    public WildcardTypeVO(WildcardEnum wildcardEnum, String boundClassName) {
        this.wildcardEnum = wildcardEnum;
        this.boundClassName = boundClassName;
    }

    public WildcardEnum getWildcardEnum() {
        return wildcardEnum;
    }

    public void setWildcardEnum(WildcardEnum wildcardEnum) {
        this.wildcardEnum = wildcardEnum;
    }

    public String getBoundClassName() {
        return boundClassName;
    }

    public void setBoundClassName(String boundClassName) {
        this.boundClassName = boundClassName;
    }
}
