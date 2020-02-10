package com.itsherman.web.javagenerator.service.impl;

import com.itsherman.web.javagenerator.dao.model.MethodDefinition;
import com.itsherman.web.javagenerator.service.MethodService;
import com.itsherman.web.javagenerator.service.vo.MethodVO;
import org.apache.commons.lang3.ClassUtils;

import java.lang.reflect.Type;

public class MethodServiceImpl implements MethodService {
    @Override
    public MethodDefinition createMethod(MethodVO methodVO) throws ClassNotFoundException {
        MethodDefinition methodDefinition = new MethodDefinition(methodVO.getSignature(),methodVO.getMethodName(),returnType, methodVO.getModifiers());
        return null;
    }
}
