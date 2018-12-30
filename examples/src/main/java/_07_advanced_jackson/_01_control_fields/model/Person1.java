package _07_advanced_jackson._01_control_fields.model;

public class Person1 {
    private int id;
    private String name;
    private double age;
    private double height; // No getter for this property

    public Person1(int id, String name, double age, double height) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.height = height;
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
