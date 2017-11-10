package com.github.guava.collect;

import com.github.guava.lang.object.Person;
import com.google.common.base.Function;
import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Multimap;
import org.junit.Test;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;
/**
 * Created by wangdongbo on 2017/11/10.
 */
public class MapTest {

    private static final Integer DEFAULT_SIZE = 5;
    private static List<Person> list = Lists.newArrayListWithCapacity(DEFAULT_SIZE);

    static {
        for (int i = 0; i < DEFAULT_SIZE; i++) {
            Person person = new Person(1L + i, "person_" + i, 1, 20 + i, "1234567890" + i, "hangzhou");
            list.add(person);
        }
    }

    @Test
    public void test1() {
        Multimap<String, String> multimap = ArrayListMultimap.create();
        for (int i = 0; i < 3; i++) {
            multimap.put("key", i + "");
        }
        assertEquals(multimap.size(), 3);

        Collection<String> list = multimap.get("key");

        assertEquals(new ArrayList<>(list).get(1), "1");
    }

    @Test
    public void test2() {
        Map<Long, Person> map = Maps.uniqueIndex(list, new Function<Person, Long>() {
            @Nullable
            @Override
            public Long apply(@Nullable Person person) {
                return person.getId();
            }
        });
        map.forEach((k, v) -> System.out.println("key: " + k + ", value: " + v.toString()));
    }

}
