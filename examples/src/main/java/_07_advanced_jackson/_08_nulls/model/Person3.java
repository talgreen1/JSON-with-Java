package _07_advanced_jackson._08_nulls.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
//@AllArgsConstructor
@NoArgsConstructor
public class Person3 {
    private int id;
    private String name;

    private final List<String> childrens = new ArrayList<>();


    public List<String> getChildrens() {
        return childrens;
    }

}
