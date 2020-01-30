package com.itsherman.web.javagenerator.dao.task;

import com.itsherman.web.javagenerator.dao.model.ParameterDefinition;

public class SimpleParameterDefinition extends ParameterDefinition {

    public SimpleParameterDefinition(String signature, String parameterName, Class parameterType) {
        super(signature, parameterName, parameterType);
    }
}
