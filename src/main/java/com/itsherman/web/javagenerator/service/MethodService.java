package com.itsherman.web.javagenerator.service;

import com.itsherman.web.javagenerator.dao.model.MethodDefinition;
import com.itsherman.web.javagenerator.service.vo.MethodVO;

public interface MethodService {

    MethodDefinition createMethod(MethodVO methodVO) throws ClassNotFoundException;
}
