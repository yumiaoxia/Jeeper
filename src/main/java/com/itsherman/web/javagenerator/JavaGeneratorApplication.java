package com.itsherman.web.javagenerator;

import com.itsherman.web.javagenerator.config.ReferencePackageConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@EnableConfigurationProperties(ReferencePackageConfig.class)
@SpringBootApplication
public class JavaGeneratorApplication {

    public static void main(String[] args) {
        SpringApplication.run(JavaGeneratorApplication.class, args);
    }

}
