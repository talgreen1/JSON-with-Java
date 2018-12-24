package _05_advanced_jackson._08_nulls.model;

import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Person2 {
    private int id;
    private String name;
    private List<String> childrensList;
    private Set<String> cars;
    private Map<Integer, String> someMap;
}
