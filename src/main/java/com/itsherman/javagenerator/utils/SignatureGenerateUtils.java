package com.itsherman.javagenerator.utils;

import org.apache.commons.lang.StringUtils;

public class SignatureGenerateUtils {

    public static final String ANNOTATION_PREFIX = "@";
    public static final String SIGNATURE_SEPARATOR = ".";

    public static String annotation(String packageName, Class annotationType) {
        return packageName + ANNOTATION_PREFIX + annotationType.getSimpleName();
    }

    public static String javaType(String basePackageName, String subPackage, String typeSimpleName) {
        if (StringUtils.isEmpty(basePackageName) || StringUtils.isEmpty(typeSimpleName)) {
            throw new NullPointerException();
        }
        String result = basePackageName;
        if (StringUtils.isNotEmpty(subPackage)) {
            result = result + SIGNATURE_SEPARATOR + subPackage;
        }
        String replace = typeSimpleName.replace(typeSimpleName.substring(0, 1), typeSimpleName.substring(0, 1).toUpperCase());

        return basePackageName + SIGNATURE_SEPARATOR + subPackage + SIGNATURE_SEPARATOR + replace;
    }
}
