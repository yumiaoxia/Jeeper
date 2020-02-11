package com.itsherman.web.javagenerator.dao.model;

import com.itsherman.web.javagenerator.enums.WildcardEnum;

public class WildcardTypeDefinition implements TypeDefinition {

    private WildcardEnum wildcardEnum;

    private String boundClassName;

    public WildcardTypeDefinition(WildcardEnum wildcardEnum) {
        this.wildcardEnum = wildcardEnum;
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
