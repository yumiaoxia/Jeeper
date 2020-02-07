package com.itsherman.web.javagenerator.service;

import com.itsherman.web.javagenerator.dao.model.AnnotationDefinition;
import com.itsherman.web.javagenerator.service.vo.AnnotationVO;

public interface AnnotationService {

    AnnotationDefinition createAnnotation(AnnotationVO annotationVO) throws ClassNotFoundException;
}
