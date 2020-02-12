package com.itsherman.web.javagenerator.service.impl;

import com.itsherman.web.javagenerator.dao.model.*;
import com.itsherman.web.javagenerator.exception.ConvertTypeException;
import com.itsherman.web.javagenerator.service.AnnotationService;
import com.itsherman.web.javagenerator.service.MethodService;
import com.itsherman.web.javagenerator.service.ParameterService;
import com.itsherman.web.javagenerator.service.vo.*;
import com.itsherman.web.javagenerator.utils.DefinitionConvertUtils;
import org.apache.commons.lang3.ClassUtils;

import javax.annotation.Resource;
import java.util.List;

public class MethodServiceImpl implements MethodService {

    @Resource
    private ParameterService parameterService;

    @Resource
    private AnnotationService annotationService;

    @Override
    public MethodDefinition createMethod(MethodVO methodVO) throws ClassNotFoundException {
        // 返回值
        TypeDefinition returnType;
        try {
            returnType = DefinitionConvertUtils.convert(methodVO.getReturnTypeVO());
        }catch (ClassNotFoundException e){
            throw new ConvertTypeException(e);
        }
        MethodDefinition methodDefinition = new MethodDefinition(methodVO.getSignature(),methodVO.getMethodName(),returnType, methodVO.getModifiers());
        //参数
        ParameterVO[] parameterTypeVOS = methodVO.getParameterTypeVOS();
        for (ParameterVO parameterTypeVO : parameterTypeVOS) {
            ParameterTypeDefinition parameterTypeDefinition = parameterService.createParameter(parameterTypeVO);
            methodDefinition.getParameterTypeDefinitions().add(parameterTypeDefinition);
        }

        List<AnnotationVO> annotations = methodVO.getAnnotations();
        if(annotations!=null){
            for (AnnotationVO annotation : annotations) {
                methodDefinition.getAnnotationDefinitions().add(annotationService.createAnnotation(annotation));
            }
        }

        if(methodVO.getExceptionClassNames() != null){
            for (String exceptionClassName : methodVO.getExceptionClassNames()) {
                methodDefinition.getThrowsExceptionTypes().add(ClassUtils.getClass(exceptionClassName));
            }
        }


        return methodDefinition;
    }


}
