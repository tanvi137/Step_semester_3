package week_12.practice_problems;

import java.util.ArrayList;
import java.util.List;

public class SectionTimetables {
    static class Timetable {
        String section;
        List<String> periods;

        Timetable(String section, List<String> periods) {
            this.section = section;
            this.periods = new ArrayList<>(periods);
        }

        Timetable copy() {
            return new Timetable(section, periods);
        }

        void setPeriod(int period, String subject) {
            periods.set(period - 1, subject);
        }

        public String toString() {
            return section + ": " + periods;
        }
    }

    public static void main(String[] args) {
        Timetable original = new Timetable(
            "CSE-A", List.of("Java", "DSA", "Maths")
        );
        Timetable copied = original.copy();
        copied.section = "CSE-B";
        copied.setPeriod(2, "Physics");

        System.out.println(original);
        System.out.println(copied);
    }
}
// copy(): O(n) time and O(n) extra space
