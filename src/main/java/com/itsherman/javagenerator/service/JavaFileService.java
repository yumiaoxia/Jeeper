package com.itsherman.javagenerator.service;

import com.itsherman.javagenerator.service.vo.JavaFileVO;

public interface JavaFileService {

    void createJavaFile(JavaFileVO javaFileVO, String signature);
}
