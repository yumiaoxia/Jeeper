package com.itsherman.web.javagenerator.service.vo;

import com.itsherman.web.javagenerator.utils.SignatureGenerateUtils;

import javax.lang.model.element.Modifier;
import java.util.List;

public abstract class AbstractParameterVO extends AbstractSignatureVO {

    private String parameterName;

    private Modifier[] modifiers;

    private List<AnnotationVO> annotationVOS;

    public AbstractParameterVO(AbstractSignatureVO parentVO, String parameterName, Modifier... modifiers) {
        super(SignatureGenerateUtils.parameter(parentVO.getSignature(),parameterName), parentVO);
        this.modifiers = modifiers;
    }

    public String getParameterName() {
        return parameterName;
    }

    public void setParameterName(String parameterName) {
        this.parameterName = parameterName;
    }

    public Modifier[] getModifiers() {
        return modifiers;
    }

    public void setModifiers(Modifier[] modifiers) {
        this.modifiers = modifiers;
    }

    public List<AnnotationVO> getAnnotationVOS() {
        return annotationVOS;
    }

    public void setAnnotationVOS(List<AnnotationVO> annotationVOS) {
        this.annotationVOS = annotationVOS;
    }
}
