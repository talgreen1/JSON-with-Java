package _05_advanced_jackson._05_custom_serializer.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Item {
    private int id;
    private String itemName;
    private User owner;
}
