package com.itsherman.web.javagenerator.dao.task;

import com.itsherman.web.javagenerator.dao.model.*;
import com.itsherman.web.javagenerator.utils.TypeNameUtils;
import com.squareup.javapoet.*;
import org.springframework.util.CollectionUtils;
import sun.reflect.generics.reflectiveObjects.GenericArrayTypeImpl;
import sun.reflect.generics.reflectiveObjects.ParameterizedTypeImpl;

import java.util.ArrayList;
import java.util.List;

public class ParameterTask extends GeneralTask<ParameterSpec> {

    private ParameterDefinition parameterDefinition;

    public ParameterTask(ParameterDefinition parameterDefinition) {
        super(parameterDefinition, ParameterTask.class);
        this.parameterDefinition = parameterDefinition;
    }

    @Override
    public ParameterSpec run() {
        ParameterSpec.Builder builder = null;
        if(parameterDefinition.getParameterEnum() == ParameterDefinition.ParameterEnum.CLASS){
            ClassParameterDefinition classParameterDefinition= (ClassParameterDefinition)parameterDefinition;
            builder = ParameterSpec.builder(ClassName.get(classParameterDefinition.getClassType()),classParameterDefinition.getParameterName(),classParameterDefinition.getModifiers());
        }else if(parameterDefinition.getParameterEnum() == ParameterDefinition.ParameterEnum.TYPE_VARIABLE){
            TypeVariableParameterDefinition typeVariableParameterDefinition = (TypeVariableParameterDefinition)parameterDefinition;
            builder = ParameterSpec.builder(TypeVariableName.get(typeVariableParameterDefinition.getVariable()),typeVariableParameterDefinition.getParameterName(),typeVariableParameterDefinition.getModifiers());
        }else if(parameterDefinition.getParameterEnum() == ParameterDefinition.ParameterEnum.ARRAY){
            ArrayParameterDefinition arrayParameterDefinition = (ArrayParameterDefinition)parameterDefinition;
            ArrayTypeName arrayTypeName = TypeNameUtils.getArrayTypeName(arrayParameterDefinition);
            builder = ParameterSpec.builder(arrayTypeName,arrayParameterDefinition.getParameterName(),arrayParameterDefinition.getModifiers());
        }else if(parameterDefinition.getParameterEnum() == ParameterDefinition.ParameterEnum.PARAMETERIZED){
            ParameterizedParameterDefinition parameterizedParameterDefinition = (ParameterizedParameterDefinition)parameterDefinition;
            ParameterizedType[] parameterizedTypes = parameterizedParameterDefinition.getParameterizedTypes();
            List<TypeName> typeNames = new ArrayList<>();
            if(parameterizedTypes != null){
                for (ParameterizedType parameterizedType : parameterizedTypes) {
                    typeNames.add(TypeNameUtils.getTypeName(parameterizedType));
                }
            }
            builder = ParameterSpec.builder(ParameterizedTypeName.get(ClassName.get(parameterizedParameterDefinition.getRawType()),typeNames.toArray(new TypeName[0])),parameterDefinition.getParameterName(),parameterDefinition.getModifiers());
        }else{
            throw new IllegalArgumentException(String.format("parameterEnum is error,task'signature is %s",parameterDefinition.getSignature()));
        }

        if (!CollectionUtils.isEmpty(parameterDefinition.getAnnotationDefinitions())) {
            for (AnnotationDefinition annotationDefinition : parameterDefinition.getAnnotationDefinitions()) {
                AnnotationTask annotationTask = new AnnotationTask(annotationDefinition);
                builder.addAnnotation(annotationTask.run());
            }
        }
        return builder.build();
    }






}
