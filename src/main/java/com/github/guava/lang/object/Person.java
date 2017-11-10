package com.github.guava.lang.object;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import com.google.common.collect.ComparisonChain;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by wangdongbo on 2017/11/9.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Person implements Comparable<Person> {
    private Long id;
    private String name;
    private int sex;
    private int age;
    private String idCard;
    private String address;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Person person = (Person) o;

        return Objects.equal(this.id, person.id)
                && Objects.equal(this.name, person.name)
                && Objects.equal(this.sex, person.sex)
                && Objects.equal(this.age, person.age)
                && Objects.equal(this.idCard, person.idCard)
                && Objects.equal(this.address, person.address);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(this);
    }

    public int compareTo(Person o) {
        return ComparisonChain.start()
                .compare(this.age, o.age)
                .compare(this.name, o.name)
                .result();
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", sex=" + sex +
                ", age=" + age +
                ", idCard='" + idCard + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
