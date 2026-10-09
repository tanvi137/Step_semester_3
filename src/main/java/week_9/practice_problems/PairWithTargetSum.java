package week_9.practice_problems;

import java.util.HashSet;
import java.util.Set;

public class PairWithTargetSum {
    public static boolean hasPairWithSum(int[] nums, int target) {
        Set<Integer> seen = new HashSet<>();

        for (int num : nums) {
            long complement = (long) target - num;
            if (complement >= Integer.MIN_VALUE &&
                complement <= Integer.MAX_VALUE &&
                seen.contains((int) complement)) {
                return true;
            }
            seen.add(num);
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(hasPairWithSum(new int[]{2, 7, 11, 15}, 9));
        System.out.println(hasPairWithSum(new int[]{3, 4, 6}, 20));
    }
}
// Time: O(n) average, Space: O(n)
// Brute force: O(n^2) time, O(1) space
