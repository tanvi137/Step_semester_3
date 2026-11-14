package week_12.practice_problems;

public class ScoreBandCounter {
    static int lowerBound(int[] scores, int x) {
        int left = 0, right = scores.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (scores[mid] < x) left = mid + 1;
            else right = mid;
        }
        return left;
    }

    static int upperBound(int[] scores, int x) {
        int left = 0, right = scores.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (scores[mid] <= x) left = mid + 1;
            else right = mid;
        }
        return left;
    }

    static void query(int[] scores, int x) {
        int below = lowerBound(scores, x);
        int exactly = upperBound(scores, x) - below;
        System.out.println(x + ": exactly " + exactly + ", below " + below);
    }

    public static void main(String[] args) {
        int[] scores = {40, 55, 70, 70, 70, 85, 90};
        query(scores, 70);
        query(scores, 60);
        query(scores, 95);
    }
}
// Each query: O(log n) time, O(1) space
// Linear scanning would take O(n)
