package com.itsherman.javagenerator.dao.model;

import javax.lang.model.element.Modifier;
import java.lang.reflect.Type;
import java.util.Collections;
import java.util.List;
import java.util.Set;

public class FieldDefinition extends ModelDefinition {


    private Type fieldType;

    private String fieldName;

    private Object defaultValue;

    private Set<Modifier> modifiers = Collections.emptySet();

    private List<AnnotationDefinition> annotationDefinitions = Collections.emptyList();

    private boolean getter;

    private boolean setter;

    public FieldDefinition(Type fieldType, String signature, String fieldName, Object defaultValue, boolean getter, boolean setter) {
        super(signature);
        this.fieldType = fieldType;
        this.fieldName = fieldName;
        this.defaultValue = defaultValue;
        this.getter = getter;
        this.setter = setter;
    }

    public Type getFieldType() {
        return fieldType;
    }

    public void setFieldType(Type fieldType) {
        this.fieldType = fieldType;
    }

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public Object getDefaultValue() {
        return defaultValue;
    }

    public void setDefaultValue(Object defaultValue) {
        this.defaultValue = defaultValue;
    }

    public Set<Modifier> getModifiers() {
        return modifiers;
    }

    public void setModifiers(Set<Modifier> modifiers) {
        this.modifiers = modifiers;
    }

    public List<AnnotationDefinition> getAnnotationDefinitions() {
        return annotationDefinitions;
    }

    public void setAnnotationDefinitions(List<AnnotationDefinition> annotationDefinitions) {
        this.annotationDefinitions = annotationDefinitions;
    }

    public boolean isGetter() {
        return getter;
    }

    public void setGetter(boolean getter) {
        this.getter = getter;
    }

    public boolean isSetter() {
        return setter;
    }

    public void setSetter(boolean setter) {
        this.setter = setter;
    }
}
