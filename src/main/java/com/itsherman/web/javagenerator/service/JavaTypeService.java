package com.itsherman.web.javagenerator.service;

import com.itsherman.web.javagenerator.dao.model.CLassDefinition;
import com.itsherman.web.javagenerator.service.vo.ClassVO;

public interface JavaTypeService {

    CLassDefinition createJavaType(ClassVO classVO) throws ClassNotFoundException;
}
