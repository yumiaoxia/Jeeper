package com.itsherman.javagenerator.service.impl;

import com.itsherman.javagenerator.dao.model.ClassDefinition;
import com.itsherman.javagenerator.service.JavaFileService;
import com.itsherman.javagenerator.service.vo.ClassVO;
import com.itsherman.javagenerator.service.vo.JavaFileVO;
import com.itsherman.javagenerator.service.vo.TypeVO;
import com.squareup.javapoet.TypeSpec;
import org.springframework.stereotype.Service;

@Service
public class JavaFileServiceImpl implements JavaFileService {


    @Override
    public void createJavaFile(JavaFileVO javaFileVO, String signature) {
        TypeVO typeVO = javaFileVO.getTypeVO();
        if (typeVO.getKind() == TypeSpec.Kind.CLASS) {
            ClassVO classVO = (ClassVO) typeVO;
            ClassDefinition classDefinition = new ClassDefinition(signature, classVO.getSimpleName(), classVO.getModifiers());
        }


    }
}
