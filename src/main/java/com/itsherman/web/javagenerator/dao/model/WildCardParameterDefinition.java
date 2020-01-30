package com.itsherman.web.javagenerator.dao.model;

import java.lang.reflect.Type;

public class WildCardParameterDefinition extends ParameterDefinition {

    /**
     * 通配符界限类型
     */
    private WildcardType wildcardType;

    /**
     * 界限类对象
     */
    private Type type;


    public WildCardParameterDefinition(String signature, String parameterName, Class parameterType) {
        super(signature, parameterName, parameterType);
    }

    public WildcardType getWildcardType() {
        return wildcardType;
    }

    public void setWildcardType(WildcardType wildcardType) {
        this.wildcardType = wildcardType;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public static enum WildcardType {
        SUPPER,
        SUB,
        SELF
    }


}
