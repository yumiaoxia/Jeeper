package com.itsherman.web.javagenerator.dao.model;

import javax.lang.model.element.Modifier;
import java.lang.reflect.Type;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class MethodDefinition extends ModelDefinition {

    private String methodName;

    private TypeDefinition returnType;

    private Modifier[] modifiers;

    private List<AnnotationDefinition> annotationDefinitions = Collections.emptyList();

    private List<Map.Entry<String, Object[]>> codeList = Collections.emptyList();

    private List<Class> throwsExceptionTypes = Collections.emptyList();

    private List<ParameterTypeDefinition> parameterTypeDefinitions = Collections.emptyList();

    public MethodDefinition(String signature, String methodName,TypeDefinition returnType, Modifier... modifiers) {
        super(signature);
        this.methodName = methodName;
        this.returnType = returnType;
        this.modifiers = modifiers;
    }

    public List<Class> getThrowsExceptionTypes() {
        return throwsExceptionTypes;
    }

    public void setThrowsExceptionTypes(List<Class> throwsExceptionTypes) {
        this.throwsExceptionTypes = throwsExceptionTypes;
    }

    public List<ParameterTypeDefinition> getParameterTypeDefinitions() {
        return parameterTypeDefinitions;
    }

    public void setParameterTypeDefinitions(List<ParameterTypeDefinition> parameterTypeDefinitions) {
        this.parameterTypeDefinitions = parameterTypeDefinitions;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public TypeDefinition getReturnType() {
        return returnType;
    }

    public void setReturnType(TypeDefinition returnType) {
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
