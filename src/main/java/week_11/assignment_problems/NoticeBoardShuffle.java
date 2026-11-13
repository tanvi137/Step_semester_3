package week_11.assignment_problems;

public class NoticeBoardShuffle {
    static int[] bubbleStats(int[] scores) {
        int passes = 0, swaps = 0;
        for (int i = 0; i < scores.length; i++) {
            boolean swapped = false;
            passes++;
            for (int j = 0; j < scores.length - i - 1; j++) {
                if (scores[j] > scores[j + 1]) {
                    int temp = scores[j];
                    scores[j] = scores[j + 1];
                    scores[j + 1] = temp;
                    swaps++;
                    swapped = true;
                }
            }
            if (!swapped) break;
        }
        return new int[]{passes, swaps};
    }

    static void test(int[] scores) {
        int[] stats = bubbleStats(scores);
        System.out.println(java.util.Arrays.toString(scores)
                + " passes = " + stats[0] + ", swaps = " + stats[1]);
    }

    public static void main(String[] args) {
        test(new int[]{5, 1, 4, 2, 8});
        test(new int[]{1, 2, 3, 4});
    }
}
// Time: O(n) best, O(n^2) worst
// Extra space: O(1), Stable: Yes
