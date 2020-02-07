package com.itsherman.web.javagenerator.utils;

import com.itsherman.web.javagenerator.constants.SignatureConstant;
import com.itsherman.web.javagenerator.exception.SignatureException;
import org.springframework.util.StringUtils;

public class SignatureGenerateUtils {


    public static String annotation(String parentSignature, String simpleName) {
        if(parentSignature == null){
            throw new SignatureException("The parentSignature can not be null!");
        }
        if(simpleName == null){
            throw new SignatureException("The simpleName can not be null!");
        }
        return parentSignature  + SignatureConstant.ANNOTATION +simpleName;
    }

    public static String type(String basePackageName, String subPackage, String typeSimpleName) {
        if (StringUtils.isEmpty(basePackageName) || StringUtils.isEmpty(typeSimpleName)) {
            throw new SignatureException("The basePackageName or subPackage can not be null!");
        }
        String result = basePackageName;
        if (!StringUtils.isEmpty(subPackage)) {
            result = result + SignatureConstant.TYPE + subPackage;
        }
        String replace = typeSimpleName.replace(typeSimpleName.substring(0, 1), typeSimpleName.substring(0, 1).toUpperCase());

        return basePackageName + SignatureConstant.TYPE + subPackage + SignatureConstant.TYPE + replace;
    }
}
