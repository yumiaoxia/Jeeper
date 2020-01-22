package com.itsherman.javagenerator;

import com.itsherman.javagenerator.web.config.ReferencePackagesConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@EnableConfigurationProperties(ReferencePackagesConfig.class)
@SpringBootApplication
public class JavaGeneratorApplication {

    public static void main(String[] args) {
        SpringApplication.run(JavaGeneratorApplication.class, args);
    }

}
