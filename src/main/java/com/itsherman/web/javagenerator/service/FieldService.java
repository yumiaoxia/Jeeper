package com.itsherman.web.javagenerator.service;

import com.itsherman.web.javagenerator.dao.model.FieldDefinition;
import com.itsherman.web.javagenerator.service.vo.FieldVO;

public interface FieldService {

    FieldDefinition createField(FieldVO fieldVO) throws ClassNotFoundException;
}
