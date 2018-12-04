package _05_advanced_jackson._05_enums.model;

import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize(using = DaySerializer.class)
public enum Day3 {
    SUNDAY(1), MONDAY(2), TUESDAY(3), WENDSDAY(4), THURSDAY(5), FRIDAY(6), SATURDAY(7);

    private int val;

    private Day3(int val) {
        this.val = val;
    }

    @JsonValue
    public int getVal() {
        return this.val;
    }
}
