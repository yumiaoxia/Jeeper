package com.itsherman.web.javagenerator;

import com.itsherman.web.common.response.ApiResponse;
import com.itsherman.web.javagenerator.service.vo.AbstractSignatureVO;
import com.squareup.javapoet.*;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import sun.reflect.generics.reflectiveObjects.ParameterizedTypeImpl;

import javax.lang.model.element.Modifier;
import java.io.IOException;
import java.io.Serializable;
import java.lang.reflect.Type;
import java.nio.file.Paths;
import java.util.Optional;

@SpringBootTest
class JeeperApplicationTests {

    @Test
    void contextLoads() throws IOException {
        ParameterizedTypeImpl make = ParameterizedTypeImpl.make(Optional.class, new Class[]{Long.class}, Optional.class);
        ParameterSpec parameterSpec1 = ParameterSpec.builder(make,"param")
                .build();

        ParameterizedTypeName parameterizedTypeName = ParameterizedTypeName.get(ClassName.get(ApiResponse.class),WildcardTypeName.supertypeOf(AbstractSignatureVO.class));

        ParameterSpec parameterSpec2 = ParameterSpec.builder(parameterizedTypeName,"param2")
                .build();

        MethodSpec methodSpec = MethodSpec.methodBuilder("func")
                .addParameter(parameterSpec1)
                .addParameter(parameterSpec2)
                .returns(ParameterizedTypeImpl.make(Optional.class,new Type[]{AbstractSignatureVO.class},Optional.class))
                .addModifiers(Modifier.PUBLIC)
                .build();

        TypeVariableName typeVariableName = TypeVariableName.get("Long");
        TypeSpec typeSpec = TypeSpec.classBuilder("Person")
                .addSuperinterface(Serializable.class)
                .addTypeVariable(typeVariableName)
                .addTypeVariable(TypeVariableName.get("T"))
                .addMethod(methodSpec)
                .build();


        JavaFile javaFile = JavaFile.builder("com.itsherman.web.javagenerator", typeSpec)
                .build();


        javaFile.writeToPath(Paths.get(System.getProperty("user.dir") + "/src/test/java"));
    }

}
