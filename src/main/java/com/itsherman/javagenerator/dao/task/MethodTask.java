package com.itsherman.javagenerator.dao.task;

import com.itsherman.javagenerator.dao.model.AnnotationDefinition;
import com.itsherman.javagenerator.dao.model.MethodDefinition;
import com.itsherman.javagenerator.dao.model.ParameterDefinition;
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
    public MethodSpec run() {
        MethodSpec methodSpec = MethodSpec.methodBuilder(methodDefinition.getMethodName())
                .addModifiers(methodDefinition.getModifiers())
                .returns(methodDefinition.getReturnType())
                .build();

        if (!CollectionUtils.isEmpty(methodDefinition.getAnnotationDefinitions())) {
            for (AnnotationDefinition annotationDefinition : methodDefinition.getAnnotationDefinitions()) {
                AnnotationTask annotationTask = new AnnotationTask(annotationDefinition);
                methodSpec.toBuilder().addAnnotation(annotationTask.run());
            }
        }

        if (!CollectionUtils.isEmpty(methodDefinition.getCodeList())) {
            for (Map.Entry<String, Object[]> codeEntry : methodDefinition.getCodeList()) {
                methodSpec.toBuilder().addCode(codeEntry.getKey(), codeEntry.getValue());
            }
        }

        if (!CollectionUtils.isEmpty(methodDefinition.getThrowsExceptionTypes())) {
            for (Class throwsExceptionType : methodDefinition.getThrowsExceptionTypes()) {
                methodSpec.toBuilder().addException(ClassName.get(throwsExceptionType));
            }
        }

        if (!CollectionUtils.isEmpty(methodDefinition.getParameterDefinitions())) {
            for (ParameterDefinition parameterDefinition : methodDefinition.getParameterDefinitions()) {
                ParameterTask parameterTask = new ParameterTask(parameterDefinition);
                methodSpec.toBuilder().addParameter(parameterTask.run());
            }
        }
        return methodSpec;
    }
}
