package com.itsherman.javagenerator.dao.task;

import com.itsherman.javagenerator.dao.model.ClassDefinition;
import com.itsherman.javagenerator.dao.model.JavaFileDefinition;
import com.itsherman.javagenerator.dao.model.TypeDefinition;
import com.squareup.javapoet.JavaFile;
import com.squareup.javapoet.TypeSpec;
import org.springframework.util.CollectionUtils;

import java.util.Map;

public class JavaFileTask extends GeneralTask<JavaFile> {

    private JavaFileDefinition definition;

    public JavaFileTask(JavaFileDefinition definition) {
        super(definition, JavaFileTask.class);
        this.definition = definition;
    }

    @Override
    public JavaFile run() {
        TypeDefinition typeDefinition = definition.getTypeDefinition();
        if (typeDefinition == null) {
            log.info("TypeDefinition in JavaFileDefinition is required,it can not be null!");
            throw new NullPointerException();
        }
        TypeSpec.Kind kind = typeDefinition.getKind();
        TypeSpec typeSpec = null;
        if (kind != null) {
            switch (kind) {
                case CLASS:
                    typeSpec = new ClassTask((ClassDefinition) typeDefinition).run();
                    break;
                default:
                    break;
            }
        } else {
            log.info("Kind in TypeDefinition is required,it can not be null!");
            throw new NullPointerException();
        }
        JavaFile.Builder builder = JavaFile.builder(definition.getPackageName(), typeSpec);

        if (!CollectionUtils.isEmpty(definition.getCommentMap())) {
            for (Map.Entry<String, Object[]> commentEntry : definition.getCommentMap().entrySet()) {
                builder.addFileComment(commentEntry.getKey(), commentEntry.getValue());
            }
        }
        return builder.build();
    }
}
