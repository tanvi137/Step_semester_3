package week_9.practice_problems;

public class MaxContainerArea {
    public static long maxContainerArea(int[] heights) {
        int left = 0, right = heights.length - 1;
        long maxArea = 0;

        while (left < right) {
            long area = (long) Math.min(heights[left], heights[right])
                        * (right - left);
            maxArea = Math.max(maxArea, area);

            if (heights[left] <= heights[right]) left++;
            else right--;
        }
        return maxArea;
    }

    public static void main(String[] args) {
        int[] heights = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(maxContainerArea(heights));
    }
}
// Time: O(n), Space: O(1)
// Brute force: O(n^2) time
