package com.hfwas;

import java.util.Objects;

/**
 * @ClassName Person
 * @Description TODO
 * @Author hfwas
 * @Date: 3:14 下午
 * @Version: 1.0
 **/
public class Person {
    private String name;
    private String value;

    public Person(String name, String value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", value='" + value + '\'' +
                '}';
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("person - finalize");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(name, person.name) && Objects.equals(value, person.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, value);
    }
}
