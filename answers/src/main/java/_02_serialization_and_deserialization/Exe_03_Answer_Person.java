package _02_serialization_and_deserialization;

import java.time.LocalDateTime;

public class Exe_03_Answer_Person {
    private String name;
    private int id;
    int numOfChildren;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumOfChildren() {
        return numOfChildren;
    }

    public void setNumOfChildren(int numOfChildren) {
        this.numOfChildren = numOfChildren;
    }

    @Override
    public String toString() {
        return "Exe_03_Answer_Person{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", numOfChildren=" + numOfChildren +
                '}';
    }
}
