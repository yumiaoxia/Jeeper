package com.itsherman.web.javagenerator.service.impl;

import com.itsherman.web.javagenerator.dao.model.TypeDefinition;
import com.itsherman.web.javagenerator.service.AnnotationService;
import com.itsherman.web.javagenerator.service.JavaTypeService;
import com.itsherman.web.javagenerator.service.vo.AnnotationVO;
import com.itsherman.web.javagenerator.service.vo.TypeVO;
import com.squareup.javapoet.TypeSpec;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class JavaTypeServiceImpl implements JavaTypeService {

    @Resource
    private AnnotationService annotationService;

    @Override
    public TypeDefinition createJavaType(TypeVO typeVO) throws ClassNotFoundException {

        TypeDefinition typeDefinition = new TypeDefinition(typeVO.getSignature(),typeVO.getKind(),typeVO.getModifiers());
        if(typeVO.getAnnotations()!=null){
            for (AnnotationVO annotation : typeVO.getAnnotations()) {
                typeDefinition.getAnnotationDefinitions().add(annotationService.createAnnotation(annotation));
            }
        }

        if(typeVO.getKind() == TypeSpec.Kind.ENUM && typeVO.getEnumConstants() != null){
            typeDefinition.getEnumConstants().addAll(typeVO.getEnumConstants());
        }
        return typeDefinition;
    }
}
