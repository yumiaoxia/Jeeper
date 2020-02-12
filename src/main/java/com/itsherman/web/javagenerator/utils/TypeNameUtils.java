package com.itsherman.web.javagenerator.utils;

import com.itsherman.web.javagenerator.dao.model.*;
import com.itsherman.web.javagenerator.enums.WildcardEnum;
import com.squareup.javapoet.*;
import org.apache.commons.lang3.ClassUtils;

import java.util.ArrayList;
import java.util.List;

public class TypeNameUtils {


    public static TypeName getTypeName(TypeDefinition typeDefinition){
        TypeName typeName;
        if(typeDefinition instanceof ClassTypeDefinition){
            ClassTypeDefinition classTypeDefinition = (ClassTypeDefinition)typeDefinition;
            typeName = ClassName.get(classTypeDefinition.getClassType());
        }else if(typeDefinition instanceof TypeVariableDefinition){
            TypeVariableDefinition typeVariableDefinition = (TypeVariableDefinition)typeDefinition;
            typeName = TypeVariableName.get(typeVariableDefinition.getVariable());
        }else if(typeDefinition instanceof ArrayTypeDefinition){
            ArrayTypeDefinition arrayTypeDefinition = (ArrayTypeDefinition)typeDefinition;
            TypeDefinition typeDefinition1 = arrayTypeDefinition.getTypeDefinition();
            typeName = ArrayTypeName.of(getTypeName(typeDefinition1));
        }else if(typeDefinition instanceof ParameterizedTypeDefinition){
            ParameterizedTypeDefinition parameterizedTypeDefinition = (ParameterizedTypeDefinition) typeDefinition;
            TypeDefinition[] typeArguments = parameterizedTypeDefinition.getTypeArguments();
            TypeName[] typeNames = new TypeName[typeArguments.length];
            for (int i = 0; i < typeArguments.length; i++) {
                typeNames[i] = getTypeName(typeArguments[i]);
            }
            typeName = ParameterizedTypeName.get(ClassName.get(parameterizedTypeDefinition.getRawType()),typeNames);
        }else if(typeDefinition instanceof WildcardTypeDefinition){
            WildcardTypeDefinition wildcardTypeDefinition = (WildcardTypeDefinition)typeDefinition;
            switch (wildcardTypeDefinition.getWildcardEnum()){
                case SUPPER:
                    typeName = WildcardTypeName.supertypeOf(wildcardTypeDefinition.getBoundClass());
                    break;
                case SUB:
                    typeName = WildcardTypeName.subtypeOf(wildcardTypeDefinition.getBoundClass());
                    break;
                default:
                    typeName = WildcardTypeName.get(wildcardTypeDefinition.getBoundClass());
                    break;
            }
        }else{
            throw new IllegalArgumentException("No such TypeDefinition");
        }
        return typeName;
    }


}
