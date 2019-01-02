package _08_advanced_jackson._02_serialization.models;

import com.fasterxml.jackson.annotation.JsonGetter;

public class Person2 {
    private int id;
    private String name;
    private double age;

    public Person2(int id, String name, double age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    @JsonGetter("ID")
    public int getId() {
        return id;
    }

    @JsonGetter
    public String upperCaseName() {
        return name.toUpperCase();
    }

    public double getAge() {
        return age;
    }


    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
