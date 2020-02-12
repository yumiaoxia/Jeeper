package com.itsherman.web.javagenerator.service.impl;

import com.itsherman.web.javagenerator.dao.model.ClassDefinition;
import com.itsherman.web.javagenerator.dao.model.FieldDefinition;
import com.itsherman.web.javagenerator.dao.model.MethodDefinition;
import com.itsherman.web.javagenerator.service.AnnotationService;
import com.itsherman.web.javagenerator.service.FieldService;
import com.itsherman.web.javagenerator.service.JavaTypeService;
import com.itsherman.web.javagenerator.service.MethodService;
import com.itsherman.web.javagenerator.service.vo.*;
import com.squareup.javapoet.TypeSpec;
import org.apache.commons.lang3.ClassUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.lang.model.element.Modifier;

@Service
public class JavaTypeServiceImpl implements JavaTypeService {

    private static String GETTER_PREFIX = "get";

    private static String SETTER_PREFIX = "set";

    private static String LOWER_BOOLEAN_GETTER_PREFIX = "is";

    @Resource
    private AnnotationService annotationService;

    @Resource
    private FieldService fieldService;

    @Resource
    private MethodService methodService;

    @Override
    public ClassDefinition createJavaType(ClassVO classVO) throws ClassNotFoundException {

        ClassDefinition classDefinition = new ClassDefinition(classVO.getSignature(), classVO.getKind(), classVO.getModifiers());

        //如果是枚举,则添加枚举成员
        if(classVO.getKind() == TypeSpec.Kind.ENUM && classVO.getEnumConstants() != null){
            classDefinition.getEnumConstants().addAll(classVO.getEnumConstants());
        }
        // 是否继承父类
        if(classVO.getSuperClassName() != null){
            classDefinition.setSuperClass(ClassUtils.getClass(classVO.getSuperClassName()));
        }

        // 是否有继承接口
        if(classVO.getSupperInterfaceNames() != null){
            for (String supperInterfaceName : classVO.getSupperInterfaceNames()) {
                classDefinition.getSuperInterfaces().add(ClassUtils.getClass(supperInterfaceName));
            }
        }

        //泛型
        if(classVO.getTypeVariableNames() != null){
            classDefinition.getTypeVariableNames().addAll(classVO.getTypeVariableNames());
        }

        // 注解
        if(classVO.getAnnotations()!=null){
            for (AnnotationVO annotation : classVO.getAnnotations()) {
                classDefinition.getAnnotationDefinitions().add(annotationService.createAnnotation(annotation));
            }
        }

        if(classVO.getFields()!= null){
            for (FieldVO field : classVO.getFields()) {
                FieldDefinition fieldDefinition = fieldService.createField(field);
                classDefinition.getFieldDefinitions().add(fieldDefinition);
                if(field.getSetter()){
                    MethodVO methodVO = new MethodVO(classVO,SETTER_PREFIX + field.getName().replace(field.getName().substring(0,1),field.getName().substring(0,1).toUpperCase()),new ClassTypeVO(Void.class.getName()), Modifier.PUBLIC);
                    classDefinition.getMethodDefinitions().add(methodService.createMethod(methodVO));
                }
                if(field.getGetter()){
                    Class fieldClass = ClassUtils.getClass(field.getTypeName());
                    String prefix = GETTER_PREFIX;
                    if(fieldClass.isAssignableFrom(boolean.class)){
                        prefix = LOWER_BOOLEAN_GETTER_PREFIX;
                    }
                    MethodVO methodVO = new MethodVO(classVO,prefix + field.getName().replace(field.getName().substring(0,1),field.getName().substring(0,1).toUpperCase()),new ClassTypeVO(fieldClass.getName()),Modifier.PUBLIC);
                    classDefinition.getMethodDefinitions().add(methodService.createMethod(methodVO));
                }
            }
        }

        return classDefinition;
    }
}
