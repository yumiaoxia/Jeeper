package com.itsherman.javagenerator.service.vo;

import java.util.Map;

public class JavaFileVO {

    private String configTitle;

    private TypeVO typeVO;

    private Map<String, Object[]> commentMap;

    public JavaFileVO(TypeVO typeVO) {
        this.typeVO = typeVO;
    }

    public Map<String, Object[]> getCommentMap() {
        return commentMap;
    }

    public void setCommentMap(Map<String, Object[]> commentMap) {
        this.commentMap = commentMap;
    }

    public String getConfigTitle() {
        return configTitle;
    }

    public void setConfigTitle(String configTitle) {
        this.configTitle = configTitle;
    }

    public TypeVO getTypeVO() {
        return typeVO;
    }

    public void setTypeVO(TypeVO typeVO) {
        this.typeVO = typeVO;
    }
}
