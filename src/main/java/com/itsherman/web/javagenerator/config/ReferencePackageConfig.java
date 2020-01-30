package com.itsherman.web.javagenerator.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "jeeper.config")
public class ReferencePackageConfig {

    private String[] referencePackages;

    public String[] getReferencePackages() {
        return referencePackages;
    }

    public void setReferencePackages(String[] referencePackages) {
        this.referencePackages = referencePackages;
    }
}
