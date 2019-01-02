package _08_advanced_jackson._02_serialization.models;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({"aMember","age", "name", "id", "zMember"})
public class Person4 {
    private int id;
    private String name;
    private double age;
    private String aMember="a";

    private String zMember="z";

    public Person4(int id, String name, double age) {
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
