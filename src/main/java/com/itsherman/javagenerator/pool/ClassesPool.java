package com.itsherman.javagenerator.pool;

import com.itsherman.javagenerator.utils.PackageUtils;
import com.itsherman.javagenerator.web.config.ReferencePackagesConfig;
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
    private ReferencePackagesConfig referencePackagesConfig;

    @PostConstruct
    public void initClasses() {
        String[] packagePaths = referencePackagesConfig.getReferencePackages();
        for (int i = 0; i < packagePaths.length; i++) {
            try {
                List<String> classNames = PackageUtils.getClassName(packagePaths[i]);
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
