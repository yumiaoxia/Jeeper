package com.itsherman.web.javagenerator.service.impl;

import com.itsherman.web.javagenerator.dao.model.ClassDefinition;
import com.itsherman.web.javagenerator.dao.model.JavaFileDefinition;
import com.itsherman.web.javagenerator.dao.task.JavaFileTask;
import com.itsherman.web.javagenerator.service.JavaFileService;
import com.itsherman.web.javagenerator.service.JavaTypeService;
import com.itsherman.web.javagenerator.service.vo.JavaFileVO;
import com.itsherman.web.javagenerator.service.vo.ClassVO;
import com.squareup.javapoet.JavaFile;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class JavaFileServiceImpl implements JavaFileService {

    @Resource
    private JavaTypeService javaTypeService;

    @Override
    public JavaFile createJavaFile(JavaFileVO javaFileVO, String signature) throws ClassNotFoundException {
        ClassVO classVO = javaFileVO.getClassVO();
        ClassDefinition CLassDefinition = javaTypeService.createJavaType(classVO);
        JavaFileDefinition javaFileDefinition = new JavaFileDefinition(null, CLassDefinition);
        JavaFileTask fileTask = new JavaFileTask(javaFileDefinition);
        return fileTask.run();
    }
}
