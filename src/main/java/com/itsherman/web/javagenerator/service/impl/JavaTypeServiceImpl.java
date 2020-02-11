package com.itsherman.web.javagenerator.service.impl;

import com.itsherman.web.javagenerator.dao.model.CLassDefinition;
import com.itsherman.web.javagenerator.service.AnnotationService;
import com.itsherman.web.javagenerator.service.JavaTypeService;
import com.itsherman.web.javagenerator.service.vo.AnnotationVO;
import com.itsherman.web.javagenerator.service.vo.FieldVO;
import com.itsherman.web.javagenerator.service.vo.ClassVO;
import com.squareup.javapoet.TypeSpec;
import org.apache.commons.lang3.ClassUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class JavaTypeServiceImpl implements JavaTypeService {

    @Resource
    private AnnotationService annotationService;

    @Override
    public CLassDefinition createJavaType(ClassVO classVO) throws ClassNotFoundException {

        CLassDefinition CLassDefinition = new CLassDefinition(classVO.getSignature(), classVO.getKind(), classVO.getModifiers());

        //如果是枚举,则添加枚举成员
        if(classVO.getKind() == TypeSpec.Kind.ENUM && classVO.getEnumConstants() != null){
            CLassDefinition.getEnumConstants().addAll(classVO.getEnumConstants());
        }
        // 是否继承父类
        if(classVO.getSuperClassName() != null){
            CLassDefinition.setSuperClass(ClassUtils.getClass(classVO.getSuperClassName()));
        }

        // 是否有继承接口
        if(classVO.getSupperInterfaceNames() != null){
            for (String supperInterfaceName : classVO.getSupperInterfaceNames()) {
                CLassDefinition.getSuperInterfaces().add(ClassUtils.getClass(supperInterfaceName));
            }
        }

        //泛型
        if(classVO.getTypeVariableNames() != null){
            CLassDefinition.getTypeVariableNames().addAll(classVO.getTypeVariableNames());
        }

        // 注解
        if(classVO.getAnnotations()!=null){
            for (AnnotationVO annotation : classVO.getAnnotations()) {
                CLassDefinition.getAnnotationDefinitions().add(annotationService.createAnnotation(annotation));
            }
        }

        if(classVO.getFields()!= null){
            for (FieldVO field : classVO.getFields()) {

            }
        }

        return CLassDefinition;
    }
}
