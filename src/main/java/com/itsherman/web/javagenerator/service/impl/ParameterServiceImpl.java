package com.itsherman.web.javagenerator.service.impl;

import com.itsherman.web.javagenerator.dao.model.*;
import com.itsherman.web.javagenerator.exception.ConvertTypeException;
import com.itsherman.web.javagenerator.service.AnnotationService;
import com.itsherman.web.javagenerator.service.ParameterService;
import com.itsherman.web.javagenerator.service.vo.*;
import com.itsherman.web.javagenerator.utils.DefinitionConvertUtils;
import org.apache.commons.lang3.ClassUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class ParameterServiceImpl implements ParameterService {

    @Resource
    private AnnotationService annotationService;

    @Override
    public ParameterTypeDefinition createParameter(ParameterVO parameterVO) {
        ParameterTypeDefinition<TypeDefinition> parameterTypeDefinition;
        try {
            parameterTypeDefinition = new ParameterTypeDefinition<>(parameterVO.getSignature(), DefinitionConvertUtils.convert(parameterVO.getTypeVO()), parameterVO.getParameterName(), parameterVO.getModifiers());
        }catch (ClassNotFoundException e){
            throw new ConvertTypeException(e);
        }
        if(parameterVO.getAnnotationVOS() != null){
            for (AnnotationVO annotationVO : parameterVO.getAnnotationVOS()) {
                try {
                    parameterTypeDefinition.getAnnotationDefinitions().add(annotationService.createAnnotation(annotationVO));
                }catch (ClassNotFoundException e){
                    throw new ConvertTypeException(e);
                }
            }
        }
        return parameterTypeDefinition;
    }

}
