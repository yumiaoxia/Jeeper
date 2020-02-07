package com.itsherman.web.javagenerator.service.vo;

public abstract class AbstractSignatureVO {

    private String signature;

    private AbstractSignatureVO parentVO;

    public AbstractSignatureVO(String signature, AbstractSignatureVO parentVO) {
        this.signature = signature;
        this.parentVO = parentVO;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public AbstractSignatureVO getParentVO() {
        return parentVO;
    }

    public void setParentVO(AbstractSignatureVO parentVO) {
        this.parentVO = parentVO;
    }
}
