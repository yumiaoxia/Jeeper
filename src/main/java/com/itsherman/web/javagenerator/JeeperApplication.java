package com.itsherman.web.javagenerator;

import com.itsherman.web.javagenerator.config.ReferencePackageConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@EnableConfigurationProperties(ReferencePackageConfig.class)
@SpringBootApplication
public class JeeperApplication {

    public static void main(String[] args) {
        SpringApplication.run(JeeperApplication.class, args);
    }

}
