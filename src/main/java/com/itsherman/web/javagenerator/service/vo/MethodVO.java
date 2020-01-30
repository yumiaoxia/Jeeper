package com.itsherman.web.javagenerator.service.vo;

import javax.lang.model.element.Modifier;
import java.util.List;
import java.util.Map;

public class MethodVO {

    private String methodName;

    private String returnTypeName;

    private Modifier[] modifiers;

    private List<AnnotationVO> annotations;

    private Map<String, Object[]> stateMap;

    private Map<String, Object[]> commentMap;

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public String getReturnTypeName() {
        return returnTypeName;
    }

    public void setReturnTypeName(String returnTypeName) {
        this.returnTypeName = returnTypeName;
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

    public Map<String, Object[]> getStateMap() {
        return stateMap;
    }

    public void setStateMap(Map<String, Object[]> stateMap) {
        this.stateMap = stateMap;
    }

    public Map<String, Object[]> getCommentMap() {
        return commentMap;
    }

    public void setCommentMap(Map<String, Object[]> commentMap) {
        this.commentMap = commentMap;
    }
}