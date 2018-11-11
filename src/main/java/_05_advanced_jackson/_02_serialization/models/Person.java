package _05_advanced_jackson._02_serialization.models;

public class Person {
    private int id;
    private String name;
    public double age;
    private double height; // No getter for this property


    public Person(int id, String name, double age) {
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

    // No getter for the age property
//    public double getAge() {
//        return age;
//    }


    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
