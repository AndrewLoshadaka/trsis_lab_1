/*
 * this code is available under GNU GPL v3
 * https://www.gnu.org/licenses/gpl-3.0.en.html
 */
package info.stepanoff.trsis.lab1.model;

import info.stepanoff.trsis.lab1.entities.Day;
import info.stepanoff.trsis.lab1.entities.Week;

import java.util.HashMap;

/**
 *
 * @author Pavel.Stepanov
 */
public class DataModel {
    private static final HashMap<Integer, Week> schedule = new HashMap<>();

    public static void setStartValue(){
        Week week = new Week();
        Day[] days = new Day[]{
                new Day("2 пара - Математика<br>3 пара - Физ.культура<br>"),
                new Day("2 пара - Математика<br>3 пара - Физ.культура<br>"),
                new Day("2 пара - Математика<br>3 пара - Физ.культура<br>"),
                new Day("2 пара - Математика<br>3 пара - Физ.культура<br>"),
                new Day("<br>")
        };
        week.setDay(days);
        schedule.put(4032, week);
    }

    public HashMap<Integer, Week> getSchedule() {
        return schedule;
    }

    public void setSchedule(int group, Week week) {
        schedule.put(group, week);
    }
}
