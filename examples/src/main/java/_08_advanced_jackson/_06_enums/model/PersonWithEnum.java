package _08_advanced_jackson._06_enums.model;



public class PersonWithEnum {
    private int id;
    private String name;
    private double age;
    private Day dayOfBirth;

    public PersonWithEnum() {
    }

    public PersonWithEnum(int id, String name, double age, Day dayOfBirth) {
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

    public Day getDayOfBirth() {
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
