package _08_advanced_jackson._06_enums.model;

import com.fasterxml.jackson.annotation.JsonValue;


public enum Day2 {
    SUNDAY(1), MONDAY(2), TUESDAY(3), WENDSDAY(4), THURSDAY(5), FRIDAY(6), SATURDAY(7);

    private int val;

    private Day2(int val) {
        this.val = val;
    }

    @JsonValue
    public int getVal() {
        return this.val;
    }
}
