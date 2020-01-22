package com.itsherman.javagenerator.dao.task;

import com.itsherman.javagenerator.dao.model.*;
import com.squareup.javapoet.ArrayTypeName;
import com.squareup.javapoet.ClassName;
import com.squareup.javapoet.ParameterSpec;
import com.squareup.javapoet.WildcardTypeName;
import org.springframework.util.CollectionUtils;
import sun.reflect.generics.reflectiveObjects.GenericArrayTypeImpl;
import sun.reflect.generics.reflectiveObjects.ParameterizedTypeImpl;

import java.lang.reflect.ParameterizedType;

public class ParameterTask extends GeneralTask<ParameterSpec> {

    private ParameterDefinition parameterDefinition;

    public ParameterTask(ParameterDefinition parameterDefinition) {
        super(parameterDefinition, ParameterTask.class);
        this.parameterDefinition = parameterDefinition;
    }

    @Override
    public ParameterSpec run() {

        ParameterSpec parameterSpec;
        if (parameterDefinition instanceof SimpleParameterDefinition) {
            SimpleParameterDefinition definition = (SimpleParameterDefinition) parameterDefinition;
            parameterSpec = ParameterSpec.builder(ClassName.get(definition.getParameterType()), definition.getParameterName(), definition.getModifiers()).build();
        } else if (parameterDefinition instanceof ParameterizedParameterDefinition) {
            // 参数化类型
            ParameterizedParameterDefinition definition = (ParameterizedParameterDefinition) parameterDefinition;
            ParameterizedType parameterizedType = ParameterizedTypeImpl.make(definition.getParameterType(), definition.getActualTypes(), definition.getOwnerType());
            parameterSpec = ParameterSpec.builder(parameterizedType, definition.getParameterName(), definition.getModifiers()).build();
        } else if (parameterDefinition instanceof WildCardParameterDefinition) {
            // 通配符参数
            WildCardParameterDefinition definition = (WildCardParameterDefinition) parameterDefinition;
            WildCardParameterDefinition.WildcardType wildcardType = definition.getWildcardType();
            WildcardTypeName wildcardTypeName = wildcardType == WildCardParameterDefinition.WildcardType.SELF ? WildcardTypeName.supertypeOf(Object.class) : wildcardType == WildCardParameterDefinition.WildcardType.SUB ? WildcardTypeName.subtypeOf(definition.getType()) : WildcardTypeName.supertypeOf(definition.getType());
            parameterSpec = ParameterSpec.builder(wildcardTypeName, definition.getParameterName(), definition.getModifiers()).build();
        } else {
            //数组类型
            ArrayParameterDefinition definition = (ArrayParameterDefinition) parameterDefinition;
            parameterSpec = ParameterSpec.builder(ArrayTypeName.get(GenericArrayTypeImpl.make(definition.getParameterType())), definition.getParameterName(), definition.getModifiers()).build();
        }

        if (!CollectionUtils.isEmpty(parameterDefinition.getAnnotationDefinitions())) {
            for (AnnotationDefinition annotationDefinition : parameterDefinition.getAnnotationDefinitions()) {
                AnnotationTask annotationTask = new AnnotationTask(annotationDefinition);
                parameterSpec.toBuilder().addAnnotation(annotationTask.run());
            }
        }
        return parameterSpec;
    }
}
