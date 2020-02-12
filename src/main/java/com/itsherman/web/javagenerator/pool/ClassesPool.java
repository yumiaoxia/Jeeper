package com.itsherman.web.javagenerator.pool;

import com.itsherman.web.javagenerator.config.ReferencePackageConfig;
import com.itsherman.web.javagenerator.utils.PackageUtils;
import org.apache.commons.lang3.ClassUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
public class ClassesPool {

    private static final Logger log = LoggerFactory.getLogger(ClassesPool.class);

    private Set<Class> classes = new HashSet<>();

    @Resource
    private ReferencePackageConfig referencePackageConfig;

    @PostConstruct
    public void initClasses() {
        List<String> packagePaths = referencePackageConfig.getReferencePackages();
        for (int i = 0; i < packagePaths.size(); i++) {
            try {
                List<String> classNames = PackageUtils.getClassName(packagePaths.get(i));
                for (String className : classNames) {
                    classes.add(ClassUtils.getClass(className));
                }
                continue;
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        log.info("已加载项目中的类共 {} 个,", classes.size());
    }

    public Set<Class> getClasses() {
        return classes;
    }

}
