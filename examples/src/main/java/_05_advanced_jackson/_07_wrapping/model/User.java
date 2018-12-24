package _05_advanced_jackson._07_wrapping.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class User {
    private int id;
    private Name name;
}
