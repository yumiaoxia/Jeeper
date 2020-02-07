package com.itsherman.web.javagenerator.service.impl;

import com.itsherman.web.javagenerator.dao.model.TypeDefinition;
import com.itsherman.web.javagenerator.service.JavaFileService;
import com.itsherman.web.javagenerator.service.JavaTypeService;
import com.itsherman.web.javagenerator.service.vo.AnnotationVO;
import com.itsherman.web.javagenerator.service.vo.JavaFileVO;
import com.itsherman.web.javagenerator.service.vo.TypeVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class JavaFileServiceImpl implements JavaFileService {

    @Resource
    private JavaTypeService javaTypeService;

    @Override
    public void createJavaFile(JavaFileVO javaFileVO, String signature) throws ClassNotFoundException {
        TypeVO typeVO = javaFileVO.getTypeVO();
        TypeDefinition typeDefinition = javaTypeService.createJavaType(typeVO);



    }
}
