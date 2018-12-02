package _05_advanced_jackson._05_enums.model;

public enum Day {
    SUNDAY(1), MONDAY(2), TUESDAY(3), WENDSDAY(4), THURSDAY(5), FRIDAY(6), SATURDAY(7);

    private int val;

    private Day(int val){
        this.val = val;
    }

    public int getVal(){
        return this.val;
    }
}