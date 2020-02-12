package com.itsherman.web.javagenerator.utils;

import com.itsherman.web.javagenerator.dao.model.*;
import com.itsherman.web.javagenerator.exception.ConvertTypeException;
import com.itsherman.web.javagenerator.service.vo.*;
import org.apache.commons.lang3.ClassUtils;

public class DefinitionConvertUtils {

    public static TypeDefinition convert(TypeVO typeVO) throws ClassNotFoundException {
        TypeDefinition typeDefinition;
        if(typeVO instanceof ClassTypeVO){
            ClassTypeVO classTypeVO = (ClassTypeVO)typeVO;
            typeDefinition = new ClassTypeDefinition(org.apache.commons.lang3.ClassUtils.getClass(classTypeVO.getClassName()));
        }else if(typeVO instanceof TypeVariableVO){
            TypeVariableVO typeVariableVO = (TypeVariableVO)typeVO;
            typeDefinition = new TypeVariableDefinition(typeVariableVO.getVariable());
        }else if(typeVO instanceof ArrayTypeVO){
            ArrayTypeVO arrayTypeVO = (ArrayTypeVO)typeVO;
            typeDefinition = new ArrayTypeDefinition(convert(arrayTypeVO.getContentType()));
        }else if(typeVO instanceof ParameterizedTypeVO){
            ParameterizedTypeVO parameterizedTypeVO = (ParameterizedTypeVO)typeVO;
            TypeVO[] typeVOS = parameterizedTypeVO.getTypeVOS();
            TypeDefinition[] typeDefinitions = new TypeDefinition[typeVOS.length];
            for (int i = 0; i < typeVOS.length; i++) {
                typeDefinitions[i] = convert(typeVOS[i]);
            }
            typeDefinition =new ParameterizedTypeDefinition(org.apache.commons.lang3.ClassUtils.getClass(parameterizedTypeVO.getRawTypeName()),typeDefinitions);
        }else if(typeVO instanceof WildcardTypeVO){
            WildcardTypeVO wildcardTypeVO = (WildcardTypeVO)typeVO;
            typeDefinition = new WildcardTypeDefinition(wildcardTypeVO.getWildcardEnum(), ClassUtils.getClass(wildcardTypeVO.getBoundClassName()));
        }else{
            throw new ConvertTypeException("No match typeDefinition!");
        }
        return typeDefinition;
    }
}
