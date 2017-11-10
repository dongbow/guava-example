package com.github.guava.base;

import com.google.common.base.CharMatcher;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by wangdongbo on 2017/11/10.
 */
public class CharMatcherTest {

    @Test
    public void test() {
        assertEquals(CharMatcher.digit().matchesAllOf("1231212"), true);
    }

    @Test
    public void test1() {
        String result = CharMatcher.digit().retainFrom("Hello 1234 567");
        assertEquals(result, "1234567");
    }

    @Test
    public void test2() {
        String result = CharMatcher.digit().or(CharMatcher.whitespace()).retainFrom("Hello 1234 567");
        assertEquals(result, " 1234 567");
    }

    @Test
    public void test3() {
        String result = CharMatcher.digit().collapseFrom("Hello 1234 567", 'x');
        assertEquals(result, "Hello x x");
    }

    @Test
    public void test4() {
        String result = CharMatcher.digit().replaceFrom("Hello 1234 567", 'x');
        assertEquals(result, "Hello xxxx xxx");
    }

    @Test
    public void test5() {
        String result = CharMatcher.inRange('3', '6').removeFrom("Hello 1234 567");
        assertEquals(result, "Hello 12 7");
    }

    @Test
    public void test6() {
        String result = CharMatcher.is('$').trimFrom("$$$ This is a $ sign $$$");
        assertEquals(result, " This is a $ sign ");
    }

}
