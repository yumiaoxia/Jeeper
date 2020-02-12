package com.itsherman.web.javagenerator.service.impl;

import com.itsherman.web.javagenerator.dao.model.AnnotationDefinition;
import com.itsherman.web.javagenerator.dao.model.FieldDefinition;
import com.itsherman.web.javagenerator.dao.model.MethodDefinition;
import com.itsherman.web.javagenerator.service.AnnotationService;
import com.itsherman.web.javagenerator.service.FieldService;
import com.itsherman.web.javagenerator.service.MethodService;
import com.itsherman.web.javagenerator.service.vo.AnnotationVO;
import com.itsherman.web.javagenerator.service.vo.ClassTypeVO;
import com.itsherman.web.javagenerator.service.vo.FieldVO;
import com.itsherman.web.javagenerator.service.vo.MethodVO;
import org.apache.commons.lang3.ClassUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import javax.lang.model.element.Modifier;

@Service
public class FieldServiceImpl implements FieldService {

    @Resource
   private AnnotationService annotationService;

    @Override
    public FieldDefinition createField(FieldVO fieldVO) throws ClassNotFoundException {
        FieldDefinition fieldDefinition = new FieldDefinition(ClassUtils.getClass(fieldVO.getTypeName()),fieldVO.getSignature(),fieldVO.getName(),fieldVO.getDefaultValue(),fieldVO.getGetter(),fieldVO.getSetter());
        if(fieldVO.getAnnotationVOS()!=null){
            for (AnnotationVO annotationVO : fieldVO.getAnnotationVOS()) {
                fieldDefinition.getAnnotationDefinitions().add(annotationService.createAnnotation(annotationVO));
            }
        }
        return fieldDefinition;
    }
}
