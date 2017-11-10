package com.github.guava.base;

import com.google.common.base.Strings;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by wangdongbo on 2017/11/10.
 */
public class StringsTest {

    @Test
    public void test() {
        assertEquals(Strings.nullToEmpty(null), "");

        assertEquals(Strings.emptyToNull(""), null);

        assertEquals(Strings.isNullOrEmpty(null), true);

        String result = Strings.padEnd("java", 10, '#');
        assertEquals(result, "java######");

        String result1 = Strings.padStart("java", 10, '#');
        assertEquals(result1, "######java");

        String result2 = Strings.repeat("java ", 2);
        assertEquals(result2, "java java ");
    }

}
