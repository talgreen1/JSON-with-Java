package _08_advanced_jackson._01_control_fields.model;

public class Person2 {
    private int id;         // Have getter
    private String name;    // Have setter
    public double age;      // Public
    private double height; // No getter no setter



    public int getId() {
        return id;
    }

    public void setName(String name){
        this.name = name;
    }


    @Override
    public String toString() {
        return "Person2{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", height=" + height +
                '}';
    }
}
