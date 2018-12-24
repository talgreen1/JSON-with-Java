package _05_advanced_jackson._08_nulls.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import lombok.AllArgsConstructor;
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
