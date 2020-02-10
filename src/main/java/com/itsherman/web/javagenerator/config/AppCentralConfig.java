package com.itsherman.web.javagenerator.config;

import com.itsherman.web.javagenerator.dao.config.SubPackageConfig;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AppCentralConfig {

    private String targetPathOfProject;

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

    public String getTargetPathOfProject() {
        return targetPathOfProject;
    }

    public void setTargetPathOfProject(String targetPathOfProject) {
        this.targetPathOfProject = targetPathOfProject;
    }
}
