package com.itsherman.web.javagenerator.service;

import com.itsherman.web.javagenerator.service.vo.JavaFileVO;

public interface JavaFileService {

    void createJavaFile(JavaFileVO javaFileVO, String signature) throws ClassNotFoundException;
}
