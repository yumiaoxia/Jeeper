package com.itsherman.web.javagenerator.service.vo;

import java.util.Map;

public class JavaFileVO extends AbstractSignatureVO{

    private String configTitle;

    private ClassVO classVO;

    private Map<String, Object[]> commentMap;

    public JavaFileVO(ClassVO classVO) {
        super(null,null);
        this.classVO = classVO;
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

    public ClassVO getClassVO() {
        return classVO;
    }

    public void setClassVO(ClassVO classVO) {
        this.classVO = classVO;
    }

}
