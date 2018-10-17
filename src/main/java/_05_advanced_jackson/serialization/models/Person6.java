package _05_advanced_jackson.serialization.models;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder(alphabetic = true)
public class Person6 {
    private int id;
    private String name;
    private double age;
    private String aMember="a";

    private String zMember="z";

    public Person6(int id, String name, double age) {
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

    public String getaMember() {
        return aMember;
    }

    public String getzMember() {
        return zMember;
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
