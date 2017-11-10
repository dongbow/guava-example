package com.github.guava.collect;

import com.google.common.collect.ObjectArrays;
import org.junit.Test;

import static org.junit.Assert.*;

public class ObjectArraysTest {
    
    String[] array1 = new String[] {"one", "two", "three"};
    String[] array2 = new String[] {"four", "five"};

    @Test
    public void test1() throws Exception {

        String[] newArray = ObjectArrays.concat(array1, array2, String.class);

        assertEquals(newArray.length, 5);
    }

    @Test
    public void test2() throws Exception {

        String[] newArray = ObjectArrays.concat(array2, "six");

        assertEquals(newArray.length, 3);
        assertEquals(newArray[2], "six");
    }

}