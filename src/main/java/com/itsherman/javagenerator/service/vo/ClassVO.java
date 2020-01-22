package com.itsherman.javagenerator.service.vo;

import com.squareup.javapoet.TypeSpec;

import javax.lang.model.element.Modifier;
import java.util.List;

public class ClassVO extends TypeVO {

    private List<FieldVO> fields;

    private List<MethodVO> methods;

    public ClassVO(String simpleName, Modifier... modifiers) {
        super(simpleName, TypeSpec.Kind.CLASS, modifiers);
    }

    public List<FieldVO> getFields() {
        return fields;
    }

    public void setFields(List<FieldVO> fields) {
        this.fields = fields;
    }

    public List<MethodVO> getMethods() {
        return methods;
    }

    public void setMethods(List<MethodVO> methods) {
        this.methods = methods;
    }
}
