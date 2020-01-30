package com.itsherman.web.javagenerator;

import org.junit.Test;

import java.util.Collections;
import java.util.List;

public class GeneralTest {

    @Test
    public void listAddNullTest() {
        List<String> emptyList = Collections.emptyList();
        emptyList.addAll(null);
        System.out.println(emptyList);
    }
}
