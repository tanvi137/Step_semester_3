package week_9.assignment_problems;

import java.util.HashMap;
import java.util.Map;
import java.util.Arrays;

public class MostPopularCanteenOrder {
    public static String mostPopular(String[] orders) {
        Map<String, Integer> counts = new HashMap<>();

        for (String item : orders) {
            counts.put(item, counts.getOrDefault(item, 0) + 1);
        }

        String best = orders[0];
        int maxCount = 0;

        for (String item : orders) {
            if (counts.get(item) > maxCount) {
                best = item;
                maxCount = counts.get(item);
            }
        }
        return "(" + best + ", " + maxCount + ")";
    }

    public static void main(String[] args) {
        String[] a = {"dosa", "idli", "vada", "dosa",
                      "idli", "dosa", "tea"};
        String[] b = {"tea", "coffee", "coffee", "tea"};

        System.out.println(mostPopular(a));
        System.out.println(mostPopular(b));
    }
}
// Time: O(n) average, Space: O(u), u = unique items
// Repeated full scans: O(n^2) time, O(1) auxiliary space
