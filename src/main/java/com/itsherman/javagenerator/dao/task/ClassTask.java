package com.itsherman.javagenerator.dao.task;

import com.itsherman.javagenerator.dao.model.*;
import com.squareup.javapoet.*;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ClassTask extends TypeTask {

    private ClassDefinition definition;

    public ClassTask(ClassDefinition definition) {
        super(definition, TypeSpec.Kind.CLASS, ClassTask.class);
        this.definition = definition;
    }

    @Override
    public TypeSpec run() {
        // 类注解
        List<AnnotationSpec> annotationSpecs = new ArrayList<>();
        if (!CollectionUtils.isEmpty(definition.getAnnotationDefinitions())) {
            for (AnnotationDefinition annotationDefinition : definition.getAnnotationDefinitions()) {
                AnnotationTask annotationTask = new AnnotationTask(annotationDefinition);
                AnnotationSpec annotationSpec = annotationTask.run();
                annotationSpecs.add(annotationSpec);
            }
        }

        // 类的成员
        List<FieldSpec> fieldSpecs = new ArrayList<>();
        if (!CollectionUtils.isEmpty(definition.getFieldDefinitions())) {
            for (FieldDefinition fieldDefinition : definition.getFieldDefinitions()) {
                FieldTask fieldTask = new FieldTask(fieldDefinition);
                fieldSpecs.add(fieldTask.run());
            }
        }

        // 类的方法
        List<MethodSpec> methodSpecs = new ArrayList<>();
        if (!CollectionUtils.isEmpty(definition.getMethodDefinitions())) {
            for (MethodDefinition methodDefinition : definition.getMethodDefinitions()) {
                MethodTask methodTask = new MethodTask(methodDefinition);
                methodSpecs.add(methodTask.run());
            }
        }


        // 内部类
        List<TypeSpec> innerTypeSpecs = new ArrayList<>();
        if (!CollectionUtils.isEmpty(definition.getInnerTypeDefinitions())) {
            for (TypeDefinition innerTypeDefinition : definition.getInnerTypeDefinitions()) {
                TypeTask typeTask;
                if (innerTypeDefinition.getKind() == TypeSpec.Kind.CLASS) {
                    typeTask = new ClassTask((ClassDefinition) innerTypeDefinition);
                    innerTypeSpecs.add(typeTask.run());
                }

            }
        }

        TypeSpec.Builder builder = TypeSpec.classBuilder(definition.getTypeName())
                .addModifiers(definition.getModifiers())
                .addAnnotations(annotationSpecs)
                .addFields(fieldSpecs)
                .addTypes(innerTypeSpecs)
                .addMethods(methodSpecs);

        //静态代码块
        if (!CollectionUtils.isEmpty(definition.getStaticBlocks())) {
            for (CodeBlock staticBlock : definition.getStaticBlocks()) {
                builder.addStaticBlock(staticBlock);
            }
        }

        // 继承类或实现类接口
        if (definition.getSuperClass() != null) {
            builder.superclass(definition.getSuperClass());
        }

        // 类变量
        if (!CollectionUtils.isEmpty(definition.getTypeVariableNames())) {
            List<TypeVariableName> typeVariables = definition.getTypeVariableNames().stream().map(TypeVariableName::get).collect(Collectors.toList());
            builder.addTypeVariables(typeVariables);
        }

        return builder.build();
    }
}
