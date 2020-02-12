package com.itsherman.web.javagenerator.service;

import com.itsherman.web.javagenerator.dao.model.ClassDefinition;
import com.itsherman.web.javagenerator.service.vo.ClassVO;

public interface JavaTypeService {

    ClassDefinition createJavaType(ClassVO classVO) throws ClassNotFoundException;
}
