package com.itsherman.web.javagenerator.dao.task;

import com.itsherman.web.javagenerator.dao.model.AnnotationDefinition;
import com.itsherman.web.javagenerator.dao.model.FieldDefinition;
import com.itsherman.web.javagenerator.dao.model.MethodDefinition;
import com.itsherman.web.javagenerator.dao.model.TypeDefinition;
import com.squareup.javapoet.ClassName;
import com.squareup.javapoet.CodeBlock;
import com.squareup.javapoet.TypeSpec;
import com.squareup.javapoet.TypeVariableName;

public class TypeTask extends GeneralTask<TypeSpec> {

    private TypeSpec.Kind kind;

    private TypeDefinition definition;

    protected TypeTask(TypeDefinition definition) {
        super(definition, TypeTask.class);
        this.definition = definition;
        this.kind = definition.getKind();
    }


    @Override
    public TypeSpec run() {
        String typeName = definition.getTypeName();
        TypeSpec.Builder builder;
        if (typeName != null && kind != null) {
            switch (kind) {
                case CLASS:
                    builder = TypeSpec.classBuilder(typeName);
                    break;
                case INTERFACE:
                    builder = TypeSpec.interfaceBuilder(typeName);
                    break;
                case ENUM:
                    builder = TypeSpec.enumBuilder(typeName);
                    if (definition.getEnumConstants().size() > 0) {
                        for (String enumConstant : definition.getEnumConstants()) {
                            builder.addEnumConstant(enumConstant);

                        }
                    }
                    break;
                default:
                    builder = TypeSpec.annotationBuilder(typeName);
                    break;
            }
        } else {
            log.error("Type name can not be null");
            throw new NullPointerException();
        }
        // 修饰符
        builder.addModifiers(definition.getModifiers());
        if (definition.getAnnotationDefinitions().size() > 0) {
            for (AnnotationDefinition annotationDefinition : definition.getAnnotationDefinitions()) {
                AnnotationTask annotationTask = new AnnotationTask(annotationDefinition);
                builder.addAnnotation(annotationTask.run());
            }
        }

        //注解
        if (definition.getAnnotationDefinitions().size() > 0) {
            for (AnnotationDefinition annotationDefinition : definition.getAnnotationDefinitions()) {
                AnnotationTask annotationTask = new AnnotationTask(annotationDefinition);
                builder.addAnnotation(annotationTask.run());
            }
        }

        // 父接口
        if (definition.getSuperInterfaces() != null) {
            for (Class superInterface : definition.getSuperInterfaces()) {
                builder.addSuperinterface(ClassName.get(superInterface));
            }
        }

        // 父类
        if (definition.getSuperClass() != null) {
            builder.superclass(definition.getSuperClass());
        }

        // 内部类
        if (definition.getInnerTypeDefinitions().size() > 0) {
            for (TypeDefinition innerTypeDefinition : definition.getInnerTypeDefinitions()) {
                TypeTask task = new TypeTask(innerTypeDefinition);
                builder.addType(task.run());
            }
        }

        // 泛型
        if (definition.getTypeVariableNames().size() > 0) {
            for (String typeVariableName : definition.getTypeVariableNames()) {
                builder.addTypeVariable(TypeVariableName.get(typeVariableName));
            }
        }

        // 属性
        if (definition.getFieldDefinitions().size() > 0) {
            for (FieldDefinition fieldDefinition : definition.getFieldDefinitions()) {
                FieldTask fieldTask = new FieldTask(fieldDefinition);
                builder.addField(fieldTask.run());
            }
        }

        // 方法
        if (definition.getMethodDefinitions().size() > 0) {
            for (MethodDefinition methodDefinition : definition.getMethodDefinitions()) {
                MethodTask methodTask = new MethodTask(methodDefinition);
                builder.addMethod(methodTask.run());
            }

        }

        // 静态代码块
        if (definition.getStaticBlocks().size() > 0) {
            for (CodeBlock staticBlock : definition.getStaticBlocks()) {
                builder.addStaticBlock(staticBlock);
            }
        }
        return builder.build();
    }
}
