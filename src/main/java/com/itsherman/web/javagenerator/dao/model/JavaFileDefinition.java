package com.itsherman.web.javagenerator.dao.model;

import java.util.HashMap;
import java.util.Map;

public class JavaFileDefinition extends ModelDefinition {

    private String packageName;

    private ClassDefinition CLassDefinition;

    private Map<String, Object[]> commentMap = new HashMap<>();

    public JavaFileDefinition(String signature, ClassDefinition CLassDefinition) {
        super(signature);
        this.CLassDefinition = CLassDefinition;
    }

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public ClassDefinition getCLassDefinition() {
        return CLassDefinition;
    }

    public void setCLassDefinition(ClassDefinition CLassDefinition) {
        this.CLassDefinition = CLassDefinition;
    }

    public Map<String, Object[]> getCommentMap() {
        return commentMap;
    }

    public void setCommentMap(Map<String, Object[]> commentMap) {
        this.commentMap = commentMap;
    }
}
