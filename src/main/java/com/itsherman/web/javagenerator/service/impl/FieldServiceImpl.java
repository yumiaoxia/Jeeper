package com.itsherman.web.javagenerator.service.impl;

import com.itsherman.web.javagenerator.dao.model.FieldDefinition;
import com.itsherman.web.javagenerator.service.FieldService;
import com.itsherman.web.javagenerator.service.vo.FieldVO;
import com.itsherman.web.javagenerator.service.vo.MethodVO;
import org.apache.commons.lang3.ClassUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.lang.model.element.Modifier;

@Service
public class FieldServiceImpl implements FieldService {

    private static String GETTER_PREFIX = "get";

    private static String SETTER_PREFIX = "set";

    private static String LOWER_BOOLEAN_GETTER_PREFIX = "is";

    @Override
    public FieldDefinition createField(FieldVO fieldVO) throws ClassNotFoundException {
        FieldDefinition fieldDefinition = new FieldDefinition(ClassUtils.getClass(fieldVO.getTypeName()),fieldVO.getSignature(),fieldVO.getName(),fieldVO.getDefaultValue(),fieldVO.getGetter(),fieldVO.getSetter());
        if(fieldDefinition.isSetter()){
            MethodVO methodVO = new MethodVO(fieldVO.getParentVO(),SETTER_PREFIX + StringUtils.replace(fieldVO.getName(),fieldVO.getName().substring(0,1),fieldVO.getName().substring(0,1).toUpperCase()),Void.class.getName(),Modifier.PUBLIC);
        }
        return fieldDefinition;
    }
}
