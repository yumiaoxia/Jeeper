package com.itsherman.web.javagenerator.dao.model;

import javax.lang.model.element.Modifier;
import java.lang.reflect.Type;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class MethodDefinition extends ModelDefinition {

    private String methodName;

    private ParameterizedType returnType;

    private Modifier[] modifiers;

    private List<AnnotationDefinition> annotationDefinitions = Collections.emptyList();

    private List<Map.Entry<String, Object[]>> codeList = Collections.emptyList();

    private List<Class<? extends Exception>> throwsExceptionTypes = Collections.emptyList();

    private List<ParameterDefinition> parameterDefinitions = Collections.emptyList();

    public MethodDefinition(String signature, String methodName,ParameterizedType returnType, Modifier... modifiers) {
        super(signature);
        this.methodName = methodName;
        this.returnType = returnType;
        this.modifiers = modifiers;
    }

    public List<Class<? extends Exception>> getThrowsExceptionTypes() {
        return throwsExceptionTypes;
    }

    public void setThrowsExceptionTypes(List<Class<? extends Exception>> throwsExceptionTypes) {
        this.throwsExceptionTypes = throwsExceptionTypes;
    }

    public List<ParameterDefinition> getParameterDefinitions() {
        return parameterDefinitions;
    }

    public void setParameterDefinitions(List<ParameterDefinition> parameterDefinitions) {
        this.parameterDefinitions = parameterDefinitions;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public ParameterizedType getReturnType() {
        return returnType;
    }

    public void setReturnType(ParameterizedType returnType) {
        this.returnType = returnType;
    }

    public Modifier[] getModifiers() {
        return modifiers;
    }

    public void setModifiers(Modifier[] modifiers) {
        this.modifiers = modifiers;
    }

    public List<AnnotationDefinition> getAnnotationDefinitions() {
        return annotationDefinitions;
    }

    public void setAnnotationDefinitions(List<AnnotationDefinition> annotationDefinitions) {
        this.annotationDefinitions = annotationDefinitions;
    }

    public List<Map.Entry<String, Object[]>> getCodeList() {
        return codeList;
    }

    public void setCodeList(List<Map.Entry<String, Object[]>> codeList) {
        this.codeList = codeList;
    }
}
