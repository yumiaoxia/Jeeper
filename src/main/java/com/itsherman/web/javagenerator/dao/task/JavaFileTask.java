package com.itsherman.web.javagenerator.dao.task;

import com.itsherman.web.javagenerator.dao.model.JavaFileDefinition;
import com.itsherman.web.javagenerator.dao.model.CLassDefinition;
import com.squareup.javapoet.JavaFile;
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
        CLassDefinition CLassDefinition = definition.getCLassDefinition();
        if (CLassDefinition == null) {
            log.info("CLassDefinition in JavaFileDefinition is required,it can not be null!");
            throw new NullPointerException();
        }
        TypeTask typeTask = new TypeTask(CLassDefinition);
        JavaFile.Builder builder = JavaFile.builder(definition.getPackageName(), typeTask.run());

        if (!CollectionUtils.isEmpty(definition.getCommentMap())) {
            for (Map.Entry<String, Object[]> commentEntry : definition.getCommentMap().entrySet()) {
                builder.addFileComment(commentEntry.getKey(), commentEntry.getValue());
            }
        }
        return builder.build();
    }
}
