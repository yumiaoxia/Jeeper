package com.itsherman.web.javagenerator.utils;

import com.itsherman.web.javagenerator.dao.model.*;
import com.squareup.javapoet.*;

import java.util.ArrayList;
import java.util.List;

public class TypeNameUtils {

    public static TypeName getTypeName(ParameterizedType parameterizedType){
        TypeName typeName;
        ParameterizedType.ParameterizedEnum parameterizedEnum = parameterizedType.getParameterizedEnum();
        if(parameterizedEnum == ParameterizedType.ParameterizedEnum.CLASS){
            ClassParameterizedType classParameterizedType = (ClassParameterizedType)parameterizedType;
            typeName = ClassName.get(classParameterizedType.getClassType());
        }else if(parameterizedEnum == ParameterizedType.ParameterizedEnum.TYPE_VARIABLE){
            TypeVariableParameterizedType typeVariableParameterizedType = (TypeVariableParameterizedType)parameterizedType;
            typeName = TypeVariableName.get(typeVariableParameterizedType.getVariable());
        }else if(parameterizedEnum == ParameterizedType.ParameterizedEnum.PARAMETERIZED){
            ParameterParameterizedType parameterParameterizedType = (ParameterParameterizedType)parameterizedType;
            List<TypeName> typeNames = new ArrayList<>();
            if(parameterParameterizedType.getParameterizedTypes()!=null){
                for (ParameterizedType type : parameterParameterizedType.getParameterizedTypes()) {
                    typeNames.add(getTypeName(type));
                }
            }
            typeName = ParameterizedTypeName.get(ClassName.get(parameterParameterizedType.getRawType()),typeNames.toArray(new TypeName[0]));
        }else if(parameterizedEnum == ParameterizedType.ParameterizedEnum.ARRAY){
            ArrayParameterizedType arrayParameterizedType = (ArrayParameterizedType)parameterizedType;
            TypeName typeName1 =  getTypeName(arrayParameterizedType.getParameterizedType());
            typeName = ArrayTypeName.of(typeName1);
        }else{
            throw new IllegalArgumentException("parameterizedEnum is error");
        }
        return typeName;
    }


    public static ArrayTypeName  getArrayTypeName(ArrayParameterDefinition parameterDefinition){
        ParameterizedType parameterizedType = parameterDefinition.getParameterizedType();
        ArrayTypeName arrayTypeName = null;
        ParameterizedType.ParameterizedEnum parameterizedEnum = parameterizedType.getParameterizedEnum();
        if(parameterizedEnum == ParameterizedType.ParameterizedEnum.CLASS){
            ClassParameterizedType classParameterizedType = (ClassParameterizedType)parameterizedType;
            arrayTypeName = ArrayTypeName.of(ClassName.get(classParameterizedType.getClassType()));
        }else if(parameterizedEnum == ParameterizedType.ParameterizedEnum.TYPE_VARIABLE){
            TypeVariableParameterizedType typeVariableParameterizedType = (TypeVariableParameterizedType)parameterizedType;
            arrayTypeName = ArrayTypeName.of(TypeVariableName.get(typeVariableParameterizedType.getVariable()));
        }else if(parameterizedEnum == ParameterizedType.ParameterizedEnum.PARAMETERIZED){
            ParameterParameterizedType parameterParameterizedType = (ParameterParameterizedType)parameterizedType;
            ParameterizedType[] parameterizedTypes = parameterParameterizedType.getParameterizedTypes();
            List<TypeName> typeNames = new ArrayList<>();
            for (ParameterizedType type : parameterizedTypes) {
                typeNames.add(getTypeName(type));
            }
            arrayTypeName = ArrayTypeName.of(ParameterizedTypeName.get(ClassName.get(parameterParameterizedType.getRawType()),typeNames.toArray(new TypeName[0])));
        }else if(parameterizedEnum == ParameterizedType.ParameterizedEnum.ARRAY){
            ArrayParameterizedType arrayParameterizedType = (ArrayParameterizedType)parameterizedType;
            arrayTypeName = ArrayTypeName.of(getTypeName(arrayParameterizedType.getParameterizedType()));
        }else {
            throw new IllegalArgumentException(String.format("parameterEnum is error,task'signature is %s",parameterDefinition.getSignature()));
        }
        return arrayTypeName;
    }
}
