package com.github.guava.collect.map;

import com.github.guava.lang.object.Person;
import com.google.common.base.Function;
import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Multimap;

import javax.annotation.Nullable;
import java.util.List;
import java.util.Map;

/**
 * Created by wangdongbo on 2017/11/9.
 */
public class MapExample {

    private static final Integer DEFAULT_SIZE = 5;
    private static List<Person> list = Lists.newArrayListWithCapacity(DEFAULT_SIZE);

    static {
        for (int i = 0; i < DEFAULT_SIZE; i++) {
            Person person = new Person(1L + i, "person_" + i, 1, 20 + i, "1234567890" + i, "hangzhou");
            list.add(person);
        }
    }

    public void demo0() {
        Multimap<String, String> multimap = ArrayListMultimap.create();
        for (int i = 10; i < 20; i++) {
            multimap.put("key", i + "");
        }
        System.out.println("multimap:" + multimap.size());
        System.out.println("multimap:" + multimap.get("key"));
    }

    public void demo1() {
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
