package com.itsherman.web.javagenerator.service.impl;

import com.itsherman.web.javagenerator.dao.model.*;
import com.itsherman.web.javagenerator.enums.WildcardEnum;
import com.itsherman.web.javagenerator.exception.ConvertTypeException;
import com.itsherman.web.javagenerator.service.MethodService;
import com.itsherman.web.javagenerator.service.vo.*;
import org.apache.commons.lang3.ClassUtils;

import java.lang.reflect.Type;

public class MethodServiceImpl implements MethodService {

    @Override
    public MethodDefinition createMethod(MethodVO methodVO) {
        ParameterizedType returnType;
        try {
            returnType = convert(methodVO.getReturnTypeVO());
        }catch (ClassNotFoundException e){
            throw new ConvertTypeException(e);
        }
        MethodDefinition methodDefinition = new MethodDefinition(methodVO.getSignature(),methodVO.getMethodName(),returnType, methodVO.getModifiers());
        ParameterTypeVO[] parameterTypeVOS = methodVO.getParameterTypeVOS();
        for (ParameterTypeVO parameterTypeVO : parameterTypeVOS) {
           TypeVO typeVO =  parameterTypeVO.getT();
            ParameterizedType parameterizedType;
           try {
               parameterizedType = convert(typeVO);
           }catch (ClassNotFoundException e){
               throw new ConvertTypeException(e);
           }
           ParameterDefinition parameterDefinition = new Pa
        }
        return methodDefinition;
    }

    private ParameterizedType convert(TypeVO typeVO) throws ClassNotFoundException {
        ParameterizedType parameterizedType;
        if(typeVO instanceof ClassTypeVO){
            ClassTypeVO classTypeVO = (ClassTypeVO)typeVO;
            parameterizedType = new ClassParameterizedType(ParameterizedType.ParameterizedEnum.CLASS,ClassUtils.getClass(classTypeVO.getClassName()));
        }else if(typeVO instanceof TypeVariableVO){
            TypeVariableVO typeVariableVO = (TypeVariableVO)typeVO;
            parameterizedType = new TypeVariableParameterizedType(ParameterizedType.ParameterizedEnum.TYPE_VARIABLE,typeVariableVO.getVariable());
        }else if(typeVO instanceof WildcardTypeVO){
            WildcardTypeVO wildcardTypeVO = (WildcardTypeVO)typeVO;
            parameterizedType = new WildcardParameterizedType(ParameterizedType.ParameterizedEnum.WILDCARD,wildcardTypeVO.getWildcardEnum(),ClassUtils.getClass(wildcardTypeVO.getBoundClassName()));
        }else if(typeVO instanceof ArrayTypeVO){
            ArrayTypeVO arrayTypeVO = (ArrayTypeVO)typeVO;
            parameterizedType = new ArrayParameterizedType(ParameterizedType.ParameterizedEnum.ARRAY,convert(arrayTypeVO.getContentType()));
        }else if(typeVO instanceof ParameterizedTypeVO){
            ParameterizedTypeVO parameterizedTypeVO = (ParameterizedTypeVO)typeVO;
            ParameterizedType[] parameterizedTypes = new ParameterizedType[parameterizedTypeVO.getTypeVOS().length];
            for (int i = 0; i < parameterizedTypeVO.getTypeVOS().length; i++) {
                parameterizedTypes[i] = convert(parameterizedTypeVO.getTypeVOS()[i]);
            }
            parameterizedType = new ParameterParameterizedType(ParameterizedType.ParameterizedEnum.PARAMETERIZED,ClassUtils.getClass(parameterizedTypeVO.getRawTypeName()),parameterizedTypes);
        }else{
            throw new ConvertTypeException("Type Error!");
        }
        return parameterizedType;
    }
}
