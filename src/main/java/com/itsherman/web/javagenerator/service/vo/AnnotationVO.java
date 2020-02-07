package com.itsherman.web.javagenerator.service.vo;

import com.itsherman.web.javagenerator.utils.SignatureGenerateUtils;

import java.util.List;

public class AnnotationVO extends AbstractSignatureVO{

    private String typeName;

    private AnnotationPropertyVO[] annotationProperties;

    public AnnotationVO(String typeName, AbstractSignatureVO parentVO,AnnotationPropertyVO... annotationProperties) {
        super(SignatureGenerateUtils.annotation(parentVO.getSignature(),typeName.substring(typeName.lastIndexOf("."))), parentVO);
        this.annotationProperties = annotationProperties;
    }


    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public AnnotationPropertyVO[] getAnnotationProperties() {
        return annotationProperties;
    }

    public void setAnnotationProperties(AnnotationPropertyVO[] annotationProperties) {
        this.annotationProperties = annotationProperties;
    }
}
