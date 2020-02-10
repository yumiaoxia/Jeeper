package com.itsherman.web.javagenerator.service.impl;

import com.itsherman.web.javagenerator.dao.model.TypeDefinition;
import com.itsherman.web.javagenerator.service.AnnotationService;
import com.itsherman.web.javagenerator.service.JavaTypeService;
import com.itsherman.web.javagenerator.service.vo.AnnotationVO;
import com.itsherman.web.javagenerator.service.vo.FieldVO;
import com.itsherman.web.javagenerator.service.vo.TypeVO;
import com.squareup.javapoet.TypeSpec;
import org.apache.commons.lang3.ClassUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class JavaTypeServiceImpl implements JavaTypeService {

    @Resource
    private AnnotationService annotationService;

    @Override
    public TypeDefinition createJavaType(TypeVO typeVO) throws ClassNotFoundException {

        TypeDefinition typeDefinition = new TypeDefinition(typeVO.getSignature(),typeVO.getKind(),typeVO.getModifiers());

        //如果是枚举,则添加枚举成员
        if(typeVO.getKind() == TypeSpec.Kind.ENUM && typeVO.getEnumConstants() != null){
            typeDefinition.getEnumConstants().addAll(typeVO.getEnumConstants());
        }
        // 是否继承父类
        if(typeVO.getSuperClassName() != null){
            typeDefinition.setSuperClass(ClassUtils.getClass(typeVO.getSuperClassName()));
        }

        // 是否有继承接口
        if(typeVO.getSupperInterfaceNames() != null){
            for (String supperInterfaceName : typeVO.getSupperInterfaceNames()) {
                typeDefinition.getSuperInterfaces().add(ClassUtils.getClass(supperInterfaceName));
            }
        }

        //泛型
        if(typeVO.getTypeVariableNames() != null){
            typeDefinition.getTypeVariableNames().addAll(typeVO.getTypeVariableNames());
        }

        // 注解
        if(typeVO.getAnnotations()!=null){
            for (AnnotationVO annotation : typeVO.getAnnotations()) {
                typeDefinition.getAnnotationDefinitions().add(annotationService.createAnnotation(annotation));
            }
        }

        if(typeVO.getFields()!= null){
            for (FieldVO field : typeVO.getFields()) {

            }
        }

        return typeDefinition;
    }
}
