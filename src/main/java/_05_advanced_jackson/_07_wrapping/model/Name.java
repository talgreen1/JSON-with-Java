package _05_advanced_jackson._07_wrapping.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Name {
    private String firstName;
    private String lastName;
}
