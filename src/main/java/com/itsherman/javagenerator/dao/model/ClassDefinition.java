package com.itsherman.javagenerator.dao.model;

import com.squareup.javapoet.CodeBlock;
import com.squareup.javapoet.TypeSpec;

import javax.lang.model.element.Modifier;
import java.util.Collections;
import java.util.List;

public class ClassDefinition extends TypeDefinition {

    private List<FieldDefinition> fieldDefinitions = Collections.emptyList();

    private List<MethodDefinition> methodDefinitions = Collections.emptyList();

    private List<CodeBlock> staticBlocks = Collections.emptyList();

    public ClassDefinition(String signature, String className, Modifier... modifiers) {
        super(signature, TypeSpec.Kind.CLASS, className, modifiers);
    }

    public List<CodeBlock> getStaticBlocks() {
        return staticBlocks;
    }

    public void setStaticBlocks(List<CodeBlock> staticBlocks) {
        this.staticBlocks = staticBlocks;
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
}
