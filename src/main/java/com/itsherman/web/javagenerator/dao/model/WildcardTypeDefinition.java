package com.itsherman.web.javagenerator.dao.model;

import com.itsherman.web.javagenerator.enums.WildcardEnum;

public class WildcardTypeDefinition implements TypeDefinition {

    private WildcardEnum wildcardEnum;

    private Class boundClass;

    public WildcardTypeDefinition(WildcardEnum wildcardEnum, Class boundClass) {
        this.wildcardEnum = wildcardEnum;
        this.boundClass = boundClass;
    }

    public WildcardEnum getWildcardEnum() {
        return wildcardEnum;
    }

    public void setWildcardEnum(WildcardEnum wildcardEnum) {
        this.wildcardEnum = wildcardEnum;
    }

    public Class getBoundClass() {
        return boundClass;
    }

    public void setBoundClass(Class boundClass) {
        this.boundClass = boundClass;
    }
}
