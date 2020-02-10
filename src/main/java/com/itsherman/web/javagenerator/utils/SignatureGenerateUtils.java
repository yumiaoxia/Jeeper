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
        return parentSignature  + SignatureConstant.SEPARATION + SignatureConstant.ANNOTATION +simpleName;
    }

    public static String member(String parentSignature, String name){
        if(parentSignature == null){
            throw new SignatureException("The parentSignature can not be null!");
        }
        if(name == null){
            throw new SignatureException("The name can not be null!");
        }
        return parentSignature + SignatureConstant.SEPARATION + SignatureConstant.MEMBER + name;
    }

    public static String parameter(String parentSignature, String name){
        if(parentSignature == null){
            throw new SignatureException("The parentSignature can not be null!");
        }
        if(name == null){
            throw new SignatureException("The name can not be null!");
        }
        return parentSignature + SignatureConstant.SEPARATION + SignatureConstant.PARAMETER + name;
    }

}
