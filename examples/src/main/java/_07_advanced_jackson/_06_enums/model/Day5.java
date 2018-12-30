package _07_advanced_jackson._06_enums.model;

import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(using = DayDeserializer.class)
public enum Day5 {
    SUNDAY(1), MONDAY(2), TUESDAY(3), WENDSDAY(4), THURSDAY(5), FRIDAY(6), SATURDAY(7);

    private int val;

    private Day5(int val) {
        this.val = val;
    }

    @JsonValue
    public int getVal() {
        return this.val;
    }
}
