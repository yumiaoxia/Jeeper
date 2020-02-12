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
    public ParameterSpec run(){
        TypeDefinition typeDefinition = definition.getTypeDefinition();

        TypeName typeName = TypeNameUtils.getTypeName(typeDefinition);
        ParameterSpec.Builder builder = ParameterSpec.builder(typeName,definition.getParameterName(),definition.getModifiers());

        if (!CollectionUtils.isEmpty(definition.getAnnotationDefinitions())) {
            for (AnnotationDefinition annotationDefinition :definition.getAnnotationDefinitions()) {
                AnnotationTask annotationTask = new AnnotationTask(annotationDefinition);
                builder.addAnnotation(annotationTask.run());
            }
        }
        return builder.build();
    }






}
