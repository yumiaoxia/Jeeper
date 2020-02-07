package com.itsherman.web.javagenerator.service.impl;

import com.itsherman.web.javagenerator.dao.model.AnnotationAttribute;
import com.itsherman.web.javagenerator.dao.model.AnnotationDefinition;
import com.itsherman.web.javagenerator.service.AnnotationService;
import com.itsherman.web.javagenerator.service.vo.AnnotationPropertyVO;
import com.itsherman.web.javagenerator.service.vo.AnnotationVO;
import com.itsherman.web.javagenerator.utils.SignatureGenerateUtils;
import org.apache.commons.lang3.ClassUtils;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.stream.Collectors;

@Service
public class AnnotationServiceImpl implements AnnotationService {

    @Override
    public AnnotationDefinition createAnnotation(AnnotationVO annotationVO) throws ClassNotFoundException {
        Class annotationClazz = ClassUtils.getClass(annotationVO.getTypeName());
        AnnotationDefinition annotationDefinition = new AnnotationDefinition(annotationVO.getSignature(),annotationClazz);
        if(annotationVO.getAnnotationProperties() != null){
            for (AnnotationPropertyVO annotationProperty : annotationVO.getAnnotationProperties()) {
                annotationDefinition.getAnnotationAttributes().add(new AnnotationAttribute(annotationProperty.getKey(), Arrays.stream(annotationProperty.getValues()).collect(Collectors.toSet())));
            }
        }
        return annotationDefinition;
    }
}
