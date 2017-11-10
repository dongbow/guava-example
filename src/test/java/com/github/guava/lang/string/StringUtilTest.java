package com.github.guava.lang.string;

import com.google.common.base.CaseFormat;
import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

/**
 * Created by wangdongbo on 2017/11/9.
 */
public class StringUtilTest {

    @Test
    public void list2String() throws Exception {
        List<String> list = Lists.newArrayList("s1", "s2", "s3");
        String result = StringUtil.list2String(list);
        System.out.println(result);
    }

    @Test
    public void string2List() throws Exception {
        String s = "s1, s2, s3";
        List<String> list = StringUtil.string2List(s);
        list.forEach(System.out::println);
    }

    @Test
    public void addSplit() throws Exception {
        String result = StringUtil.addSplit(";", "s1", "s2", "s3");
        System.out.println(result);
    }

    @Test
    public void string2Map() throws Exception {
        String s = "name:zhangsan#age:20";
        Map<String, String> map = StringUtil.string2Map(s, "#", ":");
        map.forEach((k, v) -> System.out.println("key: " + k + ", value: " + v));
    }

    @Test
    public void getDigit() throws Exception {
        String result = StringUtil.getDigit("s1s2s3s4");
        System.out.println(result);
    }

    @Test
    public void caseFormat() throws Exception {
        String s = "CONSTANT_NAME";
        String result = StringUtil.caseFormat(CaseFormat.UPPER_UNDERSCORE, CaseFormat.LOWER_CAMEL, s);
        System.out.println(result);
    }

}