package com.github.guava.lang.object;

import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.assertEquals;

/**
 * Created by wangdongbo on 2017/11/9.
 */
public class PersonTest {

    private static final Integer DEFAULT_SIZE = 5;
    private static List<Person> list = Lists.newArrayListWithCapacity(DEFAULT_SIZE);

    static {
        for (int i = 0; i < DEFAULT_SIZE; i++) {
            Person person = new Person(1L + i, "person_" + i, 1, 20 + i, "1234567890" + i, "hangzhou");
            list.add(person);
        }
        Person extraPerson = new Person(1L, "person_0", 1, 22, "12345678900", "hangzhou");
        list.add(extraPerson);
    }

    @Test
    public void repeat() {
        Set<Person> set = new HashSet<>(list);
        assertEquals(Long.valueOf(new ArrayList<>(set).size()), Long.valueOf(DEFAULT_SIZE));
    }

    @Test
    public void testToString() {
        list.forEach(person -> System.out.println(person.toString()));
    }

    @Test
    public void compare() {
        list.stream()
                .sorted(Person::compareTo)
                .forEach(person -> System.out.println(person.toString()));
    }

}