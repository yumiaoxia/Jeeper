package com.itsherman.javagenerator.dao.model;

import com.squareup.javapoet.TypeSpec;

import javax.lang.model.element.Modifier;
import java.util.Collections;
import java.util.List;

public abstract class TypeDefinition extends ModelDefinition {

    private TypeSpec.Kind kind;

    private String typeName;

    private Class superClass;

    private List<Class> superInterfaces = Collections.emptyList();

    private List<String> typeVariableNames = Collections.emptyList();

    private Modifier[] modifiers;

    private List<TypeDefinition> innerTypeDefinitions = Collections.emptyList();

    private List<AnnotationDefinition> annotationDefinitions = Collections.emptyList();


    public TypeDefinition(String signature, TypeSpec.Kind kind, String typeName, Modifier... modifiers) {
        super(signature);
        this.kind = kind;
        this.typeName = typeName;
        this.modifiers = modifiers;
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


    public List<TypeDefinition> getInnerTypeDefinitions() {
        return innerTypeDefinitions;
    }

    public void setInnerTypeDefinitions(List<TypeDefinition> innerTypeDefinitions) {
        this.innerTypeDefinitions = innerTypeDefinitions;
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
}
