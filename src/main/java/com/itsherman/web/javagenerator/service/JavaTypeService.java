package com.itsherman.web.javagenerator.service;

import com.itsherman.web.javagenerator.dao.model.TypeDefinition;
import com.itsherman.web.javagenerator.service.vo.TypeVO;

public interface JavaTypeService {

    TypeDefinition createJavaType(TypeVO typeVO) throws ClassNotFoundException;
}
