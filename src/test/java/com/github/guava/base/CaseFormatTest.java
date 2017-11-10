package com.github.guava.base;

import com.google.common.base.CaseFormat;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by wangdongbo on 2017/11/10.
 */
public class CaseFormatTest {

    String UPPER_CAMEL = "UPPER_CAMEL";
    String UPPER_UNDERSCORE = "UPPER_UNDERSCORE";

    @Test
    public void test() {
        String result = CaseFormat.UPPER_UNDERSCORE.to(CaseFormat.LOWER_CAMEL, UPPER_CAMEL);
        String result1 = CaseFormat.UPPER_UNDERSCORE.to(CaseFormat.LOWER_HYPHEN, UPPER_UNDERSCORE);

        assertEquals(result, "upperCamel");
        assertEquals(result1, "upper-underscore");
    }

}
