package com.itsherman.web.javagenerator.dao.model;

public class WildcardParameterizedType extends ParameterizedType {

    private WildcardEnum wildcardEnum;

    private Class boundClass;

    public WildcardParameterizedType(ParameterizedEnum parameterizedEnum, WildcardEnum wildcardEnum,Class boundClass) {
        super(parameterizedEnum);
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

    public enum WildcardEnum{
        SUPPER,
        SUB,
        SELF
    }
}
