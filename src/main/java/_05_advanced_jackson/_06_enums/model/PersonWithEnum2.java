package _05_advanced_jackson._06_enums.model;



public class PersonWithEnum2 {
    private int id;
    private String name;
    private double age;
    private Day2 dayOfBirth;

    public PersonWithEnum2() {
    }

    public PersonWithEnum2(int id, String name, double age, Day2 dayOfBirth) {
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

    public Day2 getDayOfBirth() {
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
