package model;

import annotations.ToString;

/**
 * Класс для демонстрации работы @ToString.
 */
@ToString
public class Person {

    private String name;

    @ToString(ToString.Mode.NO)
    private int age;

    private String city;

    public Person(String name, int age, String city) {
        this.name = name;
        this.age = age;
        this.city = city;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getCity() {
        return city;
    }
}
