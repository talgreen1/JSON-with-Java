package _08_advanced_jackson._05_custom_serializer.model;

import _08_advanced_jackson._05_custom_serializer.ItemSerializer1;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@JsonSerialize(using = ItemSerializer1.class)
public class Item1 {
    private int id;
    private String itemName;
    private User owner;
}
