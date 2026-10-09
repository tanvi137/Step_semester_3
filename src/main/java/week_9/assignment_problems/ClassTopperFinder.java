package week_9.assignment_problems;

import java.util.Arrays;

public class ClassTopperFinder {
    public static int[] findTopper(int[][] marks) {
        int bestIndex = 0, bestTotal = -1;

        for (int i = 0; i < marks.length; i++) {
            int total = 0;
            for (int mark : marks[i]) total += mark;

            if (total > bestTotal) {
                bestTotal = total;
                bestIndex = i;
            }
        }
        return new int[]{bestIndex, bestTotal};
    }

    public static void main(String[] args) {
        int[][] marks = {
            {78, 85, 90},
            {88, 92, 79},
            {65, 70, 95}
        };
        System.out.println(Arrays.toString(findTopper(marks)));
    }
}
// Time: O(m*n), Space: O(1)
