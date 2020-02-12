package com.itsherman.web.javagenerator.dao.model;

import com.squareup.javapoet.CodeBlock;
import com.squareup.javapoet.TypeSpec;

import javax.lang.model.element.Modifier;
import java.util.Collections;
import java.util.List;

public class ClassDefinition extends ModelDefinition {

    private TypeSpec.Kind kind;

    private String typeName;

    private Class superClass;

    private List<Class> superInterfaces = Collections.emptyList();

    private List<String> typeVariableNames = Collections.emptyList();

    private Modifier[] modifiers;

    private List<ClassDefinition> innerClassDefinitions = Collections.emptyList();

    private List<AnnotationDefinition> annotationDefinitions = Collections.emptyList();

    private List<FieldDefinition> fieldDefinitions = Collections.emptyList();

    private List<MethodDefinition> methodDefinitions = Collections.emptyList();

    private List<CodeBlock> staticBlocks = Collections.emptyList();

    private List<String> enumConstants = Collections.emptyList();

    public ClassDefinition(String signature, TypeSpec.Kind kind, Modifier... modifiers) {
        super(signature);
        this.kind = kind;
        this.typeName = typeName;
        this.modifiers = modifiers;
    }

    public List<FieldDefinition> getFieldDefinitions() {
        return fieldDefinitions;
    }

    public void setFieldDefinitions(List<FieldDefinition> fieldDefinitions) {
        this.fieldDefinitions = fieldDefinitions;
    }

    public List<MethodDefinition> getMethodDefinitions() {
        return methodDefinitions;
    }

    public void setMethodDefinitions(List<MethodDefinition> methodDefinitions) {
        this.methodDefinitions = methodDefinitions;
    }

    public List<String> getEnumConstants() {
        return enumConstants;
    }

    public void setEnumConstants(List<String> enumConstants) {
        this.enumConstants = enumConstants;
    }

    public List<String> getTypeVariableNames() {
        return typeVariableNames;
    }

    public void setTypeVariableNames(List<String> typeVariableNames) {
        this.typeVariableNames = typeVariableNames;
    }

    public List<Class> getSuperInterfaces() {
        return superInterfaces;
    }

    public void setSuperInterfaces(List<Class> superInterfaces) {
        this.superInterfaces = superInterfaces;
    }

    public Class getSuperClass() {
        return superClass;
    }

    public void setSuperClass(Class superClass) {
        this.superClass = superClass;
    }


    public List<ClassDefinition> getInnerClassDefinitions() {
        return innerClassDefinitions;
    }

    public void setInnerClassDefinitions(List<ClassDefinition> innerClassDefinitions) {
        this.innerClassDefinitions = innerClassDefinitions;
    }

    public List<AnnotationDefinition> getAnnotationDefinitions() {
        return annotationDefinitions;
    }

    public void setAnnotationDefinitions(List<AnnotationDefinition> annotationDefinitions) {
        this.annotationDefinitions = annotationDefinitions;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public Modifier[] getModifiers() {
        return modifiers;
    }

    public void setModifiers(Modifier[] modifiers) {
        this.modifiers = modifiers;
    }

    public TypeSpec.Kind getKind() {
        return kind;
    }

    public void setKind(TypeSpec.Kind kind) {
        this.kind = kind;
    }

    public List<CodeBlock> getStaticBlocks() {
        return staticBlocks;
    }

    public void setStaticBlocks(List<CodeBlock> staticBlocks) {
        this.staticBlocks = staticBlocks;
    }
}
