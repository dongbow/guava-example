package com.github.guava.base;

import com.google.common.base.Joiner;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.junit.Test;

import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;
/**
 * Created by wangdongbo on 2017/11/10.
 */
public class JoinerTest {

    private List<String> list = Lists.newArrayList("zhongguo", "zhejiang", "hangzhou");

    @Test
    public void test() {
        String result = Joiner.on(",").join(list);
        assertEquals(result, "zhongguo,zhejiang,hangzhou");
    }

    @Test
    public void test1() {
        list.add(null);
        String result = Joiner.on(",").skipNulls().join(list);
        assertEquals(result, "zhongguo,zhejiang,hangzhou");
    }

    @Test
    public void test2() {
        list.add(null);
        String result = Joiner.on(",").useForNull("NONE").join(list);
        assertEquals(result, "zhongguo,zhejiang,hangzhou, NONE");
    }

    @Test
    public void test3() {
        Map<String, String> map = Maps.newHashMap();
        map.put("1", "one");
        map.put("2", "two");
        map.put("3", null);
        String result = Joiner.on(",").withKeyValueSeparator("#").useForNull("NONE").join(map);
        assertEquals(result, "1,one#2,two#3,NONE");
    }

}
