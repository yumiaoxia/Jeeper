package com.itsherman.web.javagenerator.service.vo;


import com.squareup.javapoet.TypeSpec;

import javax.lang.model.element.Modifier;
import java.util.List;

public class ClassVO extends AbstractSignatureVO{

    private String superClassName;

    private Modifier[] modifiers;

    private List<AnnotationVO> annotations;

    private List<String> supperInterfaceNames;

    private List<ClassVO> innerTypes;

    private TypeSpec.Kind kind;

    private List<String> typeVariableNames;

    private List<MethodVO> methods;

    private List<FieldVO> fields;

    private List<String> enumConstants;


    public ClassVO(String signature, TypeSpec.Kind kind, AbstractSignatureVO parentVO, Modifier... modifiers) {
        super(signature,parentVO);
        this.modifiers = modifiers;
        this.kind = kind;
    }

    public TypeSpec.Kind getKind() {
        return kind;
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

    public List<ClassVO> getInnerTypes() {
        return innerTypes;
    }

    public void setInnerTypes(List<ClassVO> innerTypes) {
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
