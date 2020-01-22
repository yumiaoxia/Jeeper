package com.itsherman.javagenerator.config;

import com.itsherman.javagenerator.dao.config.SubPackageConfig;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AppCentralConfig {

    private String basePackage;

    private List<SubPackageConfig> subPackageConfigs;

    public String getBasePackage() {
        return basePackage;
    }

    public void setBasePackage(String basePackage) {
        this.basePackage = basePackage;
    }

    public List<SubPackageConfig> getSubPackageConfigs() {
        return subPackageConfigs;
    }

}
