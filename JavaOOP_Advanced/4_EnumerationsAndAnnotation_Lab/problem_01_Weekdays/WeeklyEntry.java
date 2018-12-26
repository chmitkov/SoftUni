package problem_01_Weekdays;

import java.util.Comparator;

public class WeeklyEntry {

    public final static Comparator<WeeklyEntry> COMPARE_BY_WEEKDAY = getComparatorByDay();

    private Weekday weekday;
    private String notes;

     WeeklyEntry(String weekday, String notes) {
        this.weekday = Enum.valueOf(Weekday.class, weekday.toUpperCase());
        this.notes = notes;
    }

    @Override
    public String toString() {
        return String.format("%s - %s", this.weekday, this.notes);
    }

    private static Comparator<WeeklyEntry> getComparatorByDay() {
        return Comparator.comparing(e -> e.weekday);
    }

}
