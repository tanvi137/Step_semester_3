package week_9.assignment_problems;

public class HotWeatherAlertWindows {
    public static int countAlerts(int[] readings, int k, int threshold) {
        if (k <= 0 || k > readings.length) {
            throw new IllegalArgumentException("Invalid window size");
        }

        long sum = 0, target = (long) k * threshold;
        int count = 0;

        for (int i = 0; i < k; i++) sum += readings[i];
        if (sum >= target) count++;

        for (int i = k; i < readings.length; i++) {
            sum += readings[i] - readings[i - k];
            if (sum >= target) count++;
        }
        return count;
    }

    public static void main(String[] args) {
        int[] readings = {2, 2, 2, 2, 5, 5, 5, 8};
        System.out.println(countAlerts(readings, 3, 4));
    }
}
// Time: O(n), Space: O(1)
// Recalculating each window: O(n*k) time
