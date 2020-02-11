package com.itsherman.web.javagenerator.service.vo;

import com.itsherman.web.javagenerator.dao.model.Signaturable;
import com.itsherman.web.javagenerator.utils.SignatureGenerateUtils;

import javax.lang.model.element.Modifier;
import java.util.List;
import java.util.Map;

public class MethodVO extends AbstractSignatureVO {

    private String methodName;

    private TypeVO returnTypeVO;

    private ParameterTypeVO[] parameterTypeVOS;

    private Modifier[] modifiers;

    private List<AnnotationVO> annotations;

    private Map<String, Object[]> statementMap;

    private Map<String, Object[]> commentMap;

    public MethodVO(AbstractSignatureVO parentVO,String methodName,TypeVO returnTypeVO, Modifier... modifiers) {
        super(SignatureGenerateUtils.member(parentVO.getSignature(),methodName), parentVO);
        this.methodName = methodName;
        this.returnTypeVO = returnTypeVO;
        this.modifiers = modifiers;
    }

    public ParameterTypeVO[] getParameterTypeVOS() {
        return parameterTypeVOS;
    }

    public void setParameterTypeVOS(ParameterTypeVO[] parameterTypeVOS) {
        this.parameterTypeVOS = parameterTypeVOS;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public TypeVO getReturnTypeVO() {
        return returnTypeVO;
    }

    public void setReturnTypeVO(TypeVO returnTypeVO) {
        this.returnTypeVO = returnTypeVO;
    }

    public Modifier[] getModifiers() {
        return modifiers;
    }

    public void setModifiers(Modifier[] modifiers) {
        this.modifiers = modifiers;
    }

    public List<AnnotationVO> getAnnotations() {
        return annotations;
    }

    public void setAnnotations(List<AnnotationVO> annotations) {
        this.annotations = annotations;
    }

    public Map<String, Object[]> getStatementMap() {
        return statementMap;
    }

    public void setStatementMap(Map<String, Object[]> statementMap) {
        this.statementMap = statementMap;
    }

    public Map<String, Object[]> getCommentMap() {
        return commentMap;
    }

    public void setCommentMap(Map<String, Object[]> commentMap) {
        this.commentMap = commentMap;
    }
}
