package com.itsherman.javagenerator.dao.model;

public class ModelDefinition implements Signaturable {

    private String signature;

    public ModelDefinition(String signature) {
        this.signature = signature;
    }

    @Override
    public String getSignature() {
        return null;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }
}
