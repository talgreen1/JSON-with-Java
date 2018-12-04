package _05_advanced_jackson._07_wrapping.model;

import com.fasterxml.jackson.annotation.JsonUnwrapped;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UnwrappedUser {
    private int id;

    @JsonUnwrapped
    private Name name;
}
