package _05_advanced_jackson._05_enums.model;



public class PersonWithEnum3 {
    private int id;
    private String name;
    private double age;
    private Day3 dayOfBirth;

    public PersonWithEnum3() {
    }

    public PersonWithEnum3(int id, String name, double age, Day3 dayOfBirth) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.dayOfBirth = dayOfBirth;

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

    public Day3 getDayOfBirth() {
        return dayOfBirth;
    }

    @Override
    public String toString() {
        return "PersonWithEnum{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", dayOfBirth=" + dayOfBirth +
                '}';
    }
}
