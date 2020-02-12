package com.itsherman.web.javagenerator.dao.task;

import com.itsherman.web.javagenerator.dao.model.AnnotationDefinition;
import com.itsherman.web.javagenerator.dao.model.MethodDefinition;
import com.itsherman.web.javagenerator.dao.model.ParameterDefinition;
import com.itsherman.web.javagenerator.dao.model.ParameterTypeDefinition;
import com.itsherman.web.javagenerator.utils.TypeNameUtils;
import com.squareup.javapoet.ClassName;
import com.squareup.javapoet.MethodSpec;
import org.springframework.util.CollectionUtils;

import java.util.Map;

public class MethodTask extends GeneralTask<MethodSpec> {

    private MethodDefinition methodDefinition;

    public MethodTask(MethodDefinition methodDefinition) {
        super(methodDefinition, MethodTask.class);
        this.methodDefinition = methodDefinition;
    }

    @Override
    public MethodSpec run(){
        MethodSpec.Builder builder = MethodSpec.methodBuilder(methodDefinition.getMethodName())
                .returns(TypeNameUtils.getTypeName(methodDefinition.getReturnType()))
                .addModifiers(methodDefinition.getModifiers());

        if (!CollectionUtils.isEmpty(methodDefinition.getAnnotationDefinitions())) {
            for (AnnotationDefinition annotationDefinition : methodDefinition.getAnnotationDefinitions()) {
                AnnotationTask annotationTask = new AnnotationTask(annotationDefinition);
                builder.addAnnotation(annotationTask.run());
            }
        }

        if (!CollectionUtils.isEmpty(methodDefinition.getCodeList())) {
            for (Map.Entry<String, Object[]> codeEntry : methodDefinition.getCodeList()) {
                builder.addCode(codeEntry.getKey(), codeEntry.getValue());
            }
        }

        if (!CollectionUtils.isEmpty(methodDefinition.getThrowsExceptionTypes())) {
            for (Class throwsExceptionType : methodDefinition.getThrowsExceptionTypes()) {
               builder.addException(ClassName.get(throwsExceptionType));
            }
        }

        if (!CollectionUtils.isEmpty(methodDefinition.getParameterTypeDefinitions())) {
            for (ParameterTypeDefinition parameterDefinition : methodDefinition.getParameterTypeDefinitions()) {
                ParameterTask parameterTask = new ParameterTask(parameterDefinition);
                builder.addParameter(parameterTask.run());
            }
        }
        return builder.build();
    }
}
