package com.itsherman.javagenerator.dao.task;

import com.itsherman.javagenerator.dao.model.TypeDefinition;
import com.squareup.javapoet.TypeSpec;

public abstract class TypeTask extends GeneralTask<TypeSpec> {

    private TypeSpec.Kind kind;

    TypeTask(TypeDefinition typeDefinition, TypeSpec.Kind kind, Class<? extends TypeTask> taskClass) {
        super(typeDefinition, taskClass);
        this.kind = kind;
    }

    public TypeSpec.Kind getKind() {
        return kind;
    }

    @Override
    public abstract TypeSpec run();
}
