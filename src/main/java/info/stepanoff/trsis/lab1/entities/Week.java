package info.stepanoff.trsis.lab1.entities;

import java.util.ArrayList;

public class Week {
    private Day[] day;

    public Week() {
        day = new Day[5];
    }

    public Day[] getDay() {
        return day;
    }

    public void setDay(Day[] day) {
        this.day = day;
    }
}
