package _02_serialization_and_deserialization;

import java.util.Arrays;

public class Person {
    private int id;
    private String name;
    private double age;
    private String [] favoritesColors;
    private String info = null;

    public Person() {
    }

    public Person(int id, String name, double age, String[] favoritesColors, String info) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.favoritesColors = favoritesColors;
        this.info = info;
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

    public String[] getFavoritesColors() {
        return favoritesColors;
    }

    public String getInfo() {
        return info;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", favoritesColors=" + Arrays.toString(favoritesColors) +
                ", info='" + info + '\'' +
                '}';
    }
}
