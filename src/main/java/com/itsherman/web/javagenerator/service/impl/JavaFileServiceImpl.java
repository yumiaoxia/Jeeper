package com.itsherman.web.javagenerator.service.impl;

import com.itsherman.web.javagenerator.dao.model.TypeDefinition;
import com.itsherman.web.javagenerator.service.JavaFileService;
import com.itsherman.web.javagenerator.service.vo.AnnotationVO;
import com.itsherman.web.javagenerator.service.vo.JavaFileVO;
import com.itsherman.web.javagenerator.service.vo.TypeVO;
import org.springframework.stereotype.Service;

@Service
public class JavaFileServiceImpl implements JavaFileService {


    @Override
    public void createJavaFile(JavaFileVO javaFileVO, String signature) {
        TypeVO typeVO = javaFileVO.getTypeVO();
        TypeDefinition typeDefinition = new TypeDefinition(typeVO.getSignature(), typeVO.getKind(), typeVO.getSimpleName(), typeVO.getModifiers());
        if (typeVO.getEnumConstants() != null) {
            typeDefinition.getEnumConstants().addAll(typeVO.getEnumConstants());
        }
        if (typeVO.getAnnotations() != null) {
            for (AnnotationVO annotation : typeVO.getAnnotations()) {
            }
        }


    }
}
