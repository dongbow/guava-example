package com.github.guava.collect;

import com.github.guava.lang.object.Person;
import com.google.common.base.Function;
import com.google.common.base.Predicate;
import com.google.common.collect.Collections2;
import com.google.common.collect.Lists;
import org.junit.Test;

import javax.annotation.Nullable;
import java.util.Collection;
import java.util.List;

import static org.junit.Assert.*;
/**
 * Created by wangdongbo on 2017/11/10.
 */
public class ListTest {

    private static final Integer DEFAULT_SIZE = 5;
    private static List<Person> list = Lists.newArrayListWithCapacity(DEFAULT_SIZE);

    static {
        for (int i = 0; i < DEFAULT_SIZE; i++) {
            Person person = new Person(1L + i, "person_" + i, 1, 20 + i, "1234567890" + i, "hangzhou");
            list.add(person);
        }
    }

    @Test
    public void test() {

        List<String> data = Lists.transform(list, new Function<Person, String>() {
            @Nullable
            @Override
            public String apply(@Nullable Person person) {
                return person.getName();
            }
        });

        assertEquals(data.get(3), "person_3");
    }

    @Test
    public void test1() {

        Collection<Person> data = Collections2.filter(list, new Predicate<Person>() {
            @Override
            public boolean apply(@Nullable Person person) {
                return person.getAge() > 22;
            }
        });

        assertEquals(data.size(), 2);
    }

}
