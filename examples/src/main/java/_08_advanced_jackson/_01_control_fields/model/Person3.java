package _08_advanced_jackson._01_control_fields.model;

public class Person3 {
    private int id;
    private String name;
    private double age;


    public Person3(int id, String name, double age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public Person3() {
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
        return "Person2{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
