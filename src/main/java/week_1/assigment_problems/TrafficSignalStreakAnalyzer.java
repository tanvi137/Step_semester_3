package week_1.assigment_problems;

public class TrafficSignalStreakAnalyzer {

    public static void main(String[] args) {

        String[] signals = {
            "RED", "RED", "GREEN", "GREEN", "GREEN", "YELLOW", "RED"
        };

        int currentStreak = 1;
        int longestStreak = 1;
        String longestSignal = signals[0];

        for (int i = 1; i < signals.length; i++) {

            if (signals[i].equals(signals[i - 1])) {
                currentStreak++;
            } else {
                currentStreak = 1;
            }

            if (currentStreak > longestStreak) {
                longestStreak = currentStreak;
                longestSignal = signals[i];
            }
        }

        System.out.println("Longest signal streak: "
                + longestSignal + " (" + longestStreak + ")");
    }
}
