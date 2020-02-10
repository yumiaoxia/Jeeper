package com.itsherman.web.javagenerator.service.vo;

import com.itsherman.web.javagenerator.utils.SignatureGenerateUtils;

import javax.lang.model.element.Modifier;
import java.util.ArrayList;
import java.util.List;

public class FieldVO extends AbstractSignatureVO{

    private String name;

    private String typeName;

    private Modifier[] modifiers;

    private Object defaultValue;

    private List<AnnotationVO> annotationVOS = new ArrayList<>();

    private Boolean getter;

    private Boolean setter;

    public FieldVO(AbstractSignatureVO parentVO,String name) {
        super(SignatureGenerateUtils.member(parentVO.getSignature(),name), parentVO);
        this.name = name;
    }

    public Modifier[] getModifiers() {
        return modifiers;
    }

    public void setModifiers(Modifier[] modifiers) {
        this.modifiers = modifiers;
    }

    public Object getDefaultValue() {
        return defaultValue;
    }

    public void setDefaultValue(Object defaultValue) {
        this.defaultValue = defaultValue;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public List<AnnotationVO> getAnnotationVOS() {
        return annotationVOS;
    }

    public void setAnnotationVOS(List<AnnotationVO> annotationVOS) {
        this.annotationVOS = annotationVOS;
    }

    public Boolean getGetter() {
        return getter;
    }

    public void setGetter(Boolean getter) {
        this.getter = getter;
    }

    public Boolean getSetter() {
        return setter;
    }

    public void setSetter(Boolean setter) {
        this.setter = setter;
    }
}
