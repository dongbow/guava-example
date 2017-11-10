package com.github.guava.collect;

import com.google.common.collect.HashMultiset;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Multiset;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by wangdongbo on 2017/11/10.
 */
public class SetTest {

    @Test
    public void test() {

        ImmutableSet<String> set = ImmutableSet.of("one", "two");


        Multiset<String> multiset = HashMultiset.create();

        multiset.add("nothing");
        multiset.add("nothing");

        assertEquals(multiset.count("nothing"), 2);
        assertEquals(multiset.count("something"), 0);
    }
}
