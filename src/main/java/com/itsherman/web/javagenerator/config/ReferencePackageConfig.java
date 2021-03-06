package com.itsherman.web.javagenerator.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@ConfigurationProperties(prefix = "jeeper.config")
public class ReferencePackageConfig {

    private List<String> referencePackages;

    public List<String> getReferencePackages() {
        return referencePackages;
    }

    public void setReferencePackages(List<String> referencePackages) {
        this.referencePackages = referencePackages;
    }
}
