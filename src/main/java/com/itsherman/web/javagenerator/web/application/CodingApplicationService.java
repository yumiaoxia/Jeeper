package com.itsherman.web.javagenerator.web.application;

import com.itsherman.web.common.exception.ServiceException;
import com.itsherman.web.javagenerator.config.ReferencePackageConfig;
import com.itsherman.web.javagenerator.exception.ErrorCode;
import com.itsherman.web.javagenerator.pool.ClassesPool;
import com.itsherman.web.javagenerator.web.command.ReferencePackages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class CodingApplicationService {

    @Autowired
    private ClassesPool classesPool;

    @Autowired
    private ReferencePackageConfig referencePackageConfig;

    public List<String> findMatchClassName(String name) {
        return classesPool.getClasses().stream().filter(clazz -> clazz.getSimpleName().equalsIgnoreCase(name)).map(Class::getName).collect(Collectors.toList());
    }

    public List<String> listReferencePackages() {
        return referencePackageConfig.getReferencePackages();
    }


    public void addReferencePackages(ReferencePackages command) {
        for (String referencePackage : command.getReferencePackages()) {
            List<String> packages = listAllPackages();
            if (!packages.contains(referencePackage)) {
                throw ServiceException.of(ErrorCode.PACKAGE_NOT_FOUND, referencePackage);
            }
        }
        referencePackageConfig.getReferencePackages().addAll(command.getReferencePackages());
        classesPool.initClasses();
    }

    public List<String> listAllPackages() {
      return Arrays.stream(Package.getPackages()).map(Package::getName).collect(Collectors.toList());
    }
}
