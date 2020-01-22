package com.itsherman.javagenerator.dao.model;

import com.itsherman.javagenerator.utils.SignatureGenerateUtils;

import java.util.HashMap;
import java.util.Map;

public class JavaFileDefinition extends ModelDefinition {

    private String packageName;

    private TypeDefinition typeDefinition;

    private Map<String, Object[]> commentMap = new HashMap<>();

    public JavaFileDefinition(String signature, TypeDefinition typeDefinition) {
        super(signature);
        this.typeDefinition = typeDefinition;
        packageName = signature.substring(0, signature.lastIndexOf(SignatureGenerateUtils.SIGNATURE_SEPARATOR));
    }

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public TypeDefinition getTypeDefinition() {
        return typeDefinition;
    }

    public void setTypeDefinition(TypeDefinition typeDefinition) {
        this.typeDefinition = typeDefinition;
    }

    public Map<String, Object[]> getCommentMap() {
        return commentMap;
    }

    public void setCommentMap(Map<String, Object[]> commentMap) {
        this.commentMap = commentMap;
    }
}
