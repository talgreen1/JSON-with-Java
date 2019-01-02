package _08_advanced_jackson._02_serialization.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Person9 {
    private int id;

    @JsonProperty("fullName")
    private String name;
    private double age;

    public Person9(int id, String name, double age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
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
