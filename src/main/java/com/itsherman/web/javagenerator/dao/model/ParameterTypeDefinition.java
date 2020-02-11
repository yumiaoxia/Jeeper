package com.itsherman.web.javagenerator.dao.model;

import javax.lang.model.element.Modifier;

public class ParameterTypeDefinition<T extends TypeDefinition> extends ParameterDefinition{

    private T t;

    public ParameterTypeDefinition(String signature,T t, String parameterName, Modifier... modifiers) {
        super(signature, parameterName, modifiers);
    }

    public T getTypeDefinition() {
        return t;
    }

    public void setTypeDefinition(T t) {
        this.t = t;
    }
}
