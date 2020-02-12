package com.itsherman.web.javagenerator.service;

import com.itsherman.web.javagenerator.dao.model.ParameterTypeDefinition;
import com.itsherman.web.javagenerator.service.vo.AbstractParameterVO;
import com.itsherman.web.javagenerator.service.vo.ParameterVO;

public interface ParameterService {

    ParameterTypeDefinition createParameter(ParameterVO parameterVO);
}
