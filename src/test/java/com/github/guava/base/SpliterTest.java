package com.github.guava.base;

import com.google.common.base.Splitter;
import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;


/**
 * Created by wangdongbo on 2017/11/10.
 */
public class SpliterTest {

    @Test
    public void test() {
        String s = "a,b,c,d,  e,f,,g";
        List<String> result = Splitter.on(",").trimResults().omitEmptyStrings().splitToList(s);
        assertEquals(result.size(), 7);
    }

    @Test
    public void test1() {
        Iterable<String> result = Splitter.onPattern("\\d+").split("Java3Scala4Haskell0Brainfuck5Kotlin");
        List<String> list = Lists.newArrayList();
        Iterator<String> iterator = result.iterator();
        while (iterator.hasNext()) {
            list.add(iterator.next());
        }
        assertEquals(list.size(), 5);
        assertEquals(list.get(0), "Java");
    }

    @Test
    public void test2() {
        String s = "1,one#2,two";
        Map<String, String> map = Splitter.on(",").withKeyValueSeparator("#").split(s);
        assertEquals(map.size(), 2);
        assertEquals(map.get("1"), "one");
    }

}
