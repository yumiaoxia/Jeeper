package com.itsherman.web.javagenerator.dao.model;

import java.util.HashSet;
import java.util.Set;

/**
 * 注解属性
 */
public class AnnotationAttribute {

    private String attrName;

    private Set<Object> attrValue = new HashSet<>();

    public String getAttrName() {
        return attrName;
    }

    public void setAttrName(String attrName) {
        this.attrName = attrName;
    }

    public Set<Object> getAttrValue() {
        return attrValue;
    }

    public void setAttrValue(Set<Object> attrValue) {
        this.attrValue = attrValue;
    }
}
