package com.github.guava.collect.list;

import com.github.guava.lang.object.Person;
import com.google.common.base.Function;
import com.google.common.base.Strings;
import com.google.common.collect.Lists;

import javax.annotation.Nullable;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by wangdongbo on 2017/11/9.
 */
public class ListExample {

    private static final Integer DEFAULT_SIZE = 5;
    private static List<Person> list = Lists.newArrayListWithCapacity(DEFAULT_SIZE);

    static {
        for (int i = 0; i < DEFAULT_SIZE; i++) {
            Person person = new Person(1L + i, "person_" + i, 1, 20 + i, "1234567890" + i, "hangzhou");
            list.add(person);
        }
    }

    public void demo0() {

        // guava
        List<String> data = Lists.transform(list, new Function<Person, String>() {
            @Nullable
            @Override
            public String apply(@Nullable Person person) {
                return person.getName();
            }
        });
        data.forEach(System.out::println);

        //jdk8
        list.stream()
                .filter(person -> !Strings.isNullOrEmpty(person.getName()))
                .map(Person::getName)
                .collect(Collectors.toList())
                .forEach(System.out::println);
    }

    public void demo1() {

    }

    public static void main(String[] args) {
        new ListExample().demo1();
    }
}
