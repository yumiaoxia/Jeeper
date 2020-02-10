package com.itsherman.web.javagenerator.service;

import com.itsherman.web.javagenerator.service.vo.JavaFileVO;
import com.squareup.javapoet.JavaFile;

public interface JavaFileService {

    JavaFile createJavaFile(JavaFileVO javaFileVO, String signature) throws ClassNotFoundException;
}
