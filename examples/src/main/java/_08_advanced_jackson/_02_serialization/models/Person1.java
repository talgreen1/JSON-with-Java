package _08_advanced_jackson._02_serialization.models;

public class Person1 {
    private int id;
    private String name;
    private double age;

    public Person1(int id, String name, double age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public String upperName() {
        return name.toUpperCase();
    }

    public double getAge() {
        return age;
    }

    public String getSomeText() {
        return "Hard coded text - no class member";
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
