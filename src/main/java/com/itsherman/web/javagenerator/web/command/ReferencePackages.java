package com.itsherman.web.javagenerator.web.command;

import io.swagger.annotations.ApiModelProperty;

import java.util.List;

public class ReferencePackages {

    @ApiModelProperty("关联包名列表")
    private List<String> referencePackages;

    public List<String> getReferencePackages() {
        return referencePackages;
    }

    public void setReferencePackages(List<String> referencePackages) {
        this.referencePackages = referencePackages;
    }
}
