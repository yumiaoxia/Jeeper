package com.itsherman.web.javagenerator.service.vo;


import com.squareup.javapoet.TypeSpec;

import javax.lang.model.element.Modifier;
import java.util.List;

public abstract class TypeVO {

    private String simpleName;

    private String superClassName;

    private Modifier[] modifiers;

    private List<AnnotationVO> annotations;

    private List<String> supperInterfaceNames;

    private List<TypeVO> innerTypes;

    private TypeSpec.Kind kind;

    private List<String> typeVariableNames;

    private List<MethodVO> methods;

    private List<FieldVO> fields;

    private List<String> enumConstants;

    private String signature;

    public TypeVO(String simpleName, TypeSpec.Kind kind, Modifier... modifiers) {
        this.simpleName = simpleName;
        this.modifiers = modifiers;
        this.kind = kind;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public TypeSpec.Kind getKind() {
        return kind;
    }

    public String getSimpleName() {
        return simpleName;
    }

    public void setSimpleName(String simpleName) {
        this.simpleName = simpleName;
    }

    public String getSuperClassName() {
        return superClassName;
    }

    public void setSuperClassName(String superClassName) {
        this.superClassName = superClassName;
    }

    public Modifier[] getModifiers() {
        return modifiers;
    }

    public void setModifiers(Modifier[] modifiers) {
        this.modifiers = modifiers;
    }

    public List<AnnotationVO> getAnnotations() {
        return annotations;
    }

    public void setAnnotations(List<AnnotationVO> annotations) {
        this.annotations = annotations;
    }

    public List<String> getSupperInterfaceNames() {
        return supperInterfaceNames;
    }

    public void setSupperInterfaceNames(List<String> supperInterfaceNames) {
        this.supperInterfaceNames = supperInterfaceNames;
    }

    public List<TypeVO> getInnerTypes() {
        return innerTypes;
    }

    public void setInnerTypes(List<TypeVO> innerTypes) {
        this.innerTypes = innerTypes;
    }

    public void setKind(TypeSpec.Kind kind) {
        this.kind = kind;
    }

    public List<String> getTypeVariableNames() {
        return typeVariableNames;
    }

    public void setTypeVariableNames(List<String> typeVariableNames) {
        this.typeVariableNames = typeVariableNames;
    }

    public List<MethodVO> getMethods() {
        return methods;
    }

    public void setMethods(List<MethodVO> methods) {
        this.methods = methods;
    }

    public List<FieldVO> getFields() {
        return fields;
    }

    public void setFields(List<FieldVO> fields) {
        this.fields = fields;
    }

    public List<String> getEnumConstants() {
        if (this.kind == null || this.kind != TypeSpec.Kind.ENUM) {
            return null;
        }
        return enumConstants;
    }

    public void setEnumConstants(List<String> enumConstants) {
        if (this.kind == null || this.kind != TypeSpec.Kind.ENUM) {
            throw new UnsupportedOperationException();
        }
        this.enumConstants = enumConstants;
    }
}
