package info.stepanoff.trsis.lab1.entities;

public class Group {
    private int number;
    private Week week;

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Week getWeek() {
        return week;
    }

    public void setWeek(Week week) {
        this.week = week;
    }

    public Group(int number, Week week) {
        this.number = number;
        this.week = week;
    }
}
