package _07_advanced_jackson._08_nulls.model;

import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Person1 {
    private int id;
    private String name;

    @JsonSetter(nulls = Nulls.AS_EMPTY)
    private List<String> childrens;
}
