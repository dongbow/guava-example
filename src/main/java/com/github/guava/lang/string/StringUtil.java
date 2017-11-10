package com.github.guava.lang.string;

import com.google.common.base.CaseFormat;
import com.google.common.base.CharMatcher;
import com.google.common.base.Joiner;
import com.google.common.base.Splitter;

import java.util.List;
import java.util.Map;

/**
 * Created by wangdongbo on 2017/11/9.
 */
public class StringUtil {

    public static String list2String(List<String> list) {
        return list2String(list, ";");
    }

    public static String list2String(List<String> list, String split) {
        return Joiner.on(split).skipNulls().join(list);
    }

    public static List<String> string2List(String s) {
        return string2List(s, ",");
    }

    public static List<String> string2List(String s, String split) {
        return Splitter.on(split).trimResults().omitEmptyStrings().splitToList(s);
    }

    public static Map<String, String> string2Map(String s, String split, String valueSplit) {
        return Splitter.on(split).withKeyValueSeparator(valueSplit).split(s);
    }

    public static String addSplit(String split, String... object) {
        return Joiner.on(split).join(object);
    }

    public static String getDigit(String s) {
        return CharMatcher.digit().retainFrom(s);
    }

    public static String caseFormat(CaseFormat src, CaseFormat order, String s) {
        return src.to(order, s);
    }
}
