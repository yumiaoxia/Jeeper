package com.itsherman.web.javagenerator.dao.task;

import com.itsherman.web.javagenerator.dao.model.*;
import com.itsherman.web.javagenerator.utils.TypeNameUtils;
import com.squareup.javapoet.*;
import org.apache.commons.lang3.ClassUtils;
import org.springframework.util.CollectionUtils;
import sun.reflect.generics.reflectiveObjects.GenericArrayTypeImpl;
import sun.reflect.generics.reflectiveObjects.ParameterizedTypeImpl;

import javax.lang.model.element.Modifier;
import java.util.ArrayList;
import java.util.List;

public class ParameterTask extends GeneralTask<ParameterSpec> {

    private ParameterTypeDefinition definition;

    public ParameterTask(ParameterTypeDefinition definition) {
        super(definition, ParameterTask.class);
        this.definition = definition;
    }

    @Override
    public ParameterSpec run() {
        ParameterSpec.Builder builder = null;
        String parameterName = definition.getParameterName();
        Modifier[] modifiers = definition.getModifiers();
        TypeDefinition typeDefinition = definition.getTypeDefinition();

        if(typeDefinition instanceof ClassTypeDefinition){
            ClassTypeDefinition classTypeDefinition = (ClassTypeDefinition)typeDefinition;
            builder = ParameterSpec.builder(ClassName.get(ClassUtils.getClass(classTypeDefinition.getClassName())),parameterName,modifiers);
        }else if(typeDefinition instanceof TypeVariableDefinition){
            TypeVariableDefinition typeVariableDefinition = (TypeVariableDefinition)typeDefinition;
            builder = ParameterSpec.builder(TypeVariableName.get(typeVariableDefinition.getVariable()),parameterName,modifiers);
        }else if(typeDefinition instanceof ArrayTypeDefinition){
            ArrayTypeDefinition arrayTypeDefinition = (ArrayTypeDefinition)typeDefinition;
            arrayTypeDefinition.getTypeDefinition()
            builder = ParameterSpec.builder(ArrayTypeName.of())
        }






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
