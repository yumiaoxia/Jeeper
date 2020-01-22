package com.itsherman.javagenerator;

import com.squareup.javapoet.JavaFile;
import com.squareup.javapoet.TypeSpec;
import com.squareup.javapoet.TypeVariableName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.io.Serializable;
import java.nio.file.Paths;

@SpringBootTest
class JavaGeneratorApplicationTests {

    @Test
    void contextLoads() throws IOException {
        TypeVariableName typeVariableName = TypeVariableName.get("Long");
        TypeSpec typeSpec = TypeSpec.classBuilder("Person")
                .addSuperinterface(Serializable.class)
                .addTypeVariable(typeVariableName)
                .build();


        JavaFile javaFile = JavaFile.builder("com.itsherman.javagenerator", typeSpec)
                .build();


        javaFile.writeToPath(Paths.get(System.getProperty("user.dir") + "/src/test/java"));
    }

}
