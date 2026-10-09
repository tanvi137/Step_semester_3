package week_9.practice_problems;

import java.util.Arrays;

public class WarehouseGridSummary {
    public static long[] warehouseSummary(int[][] grid) {
        long total = 0;
        int max = -1, row = -1, col = -1;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                total += grid[i][j];
                if (grid[i][j] > max) {
                    max = grid[i][j];
                    row = i;
                    col = j;
                }
            }
        }
        return new long[]{total, row, col};
    }

    public static void main(String[] args) {
        int[][] grid = {{4, 9, 2}, {7, 1, 6}, {3, 12, 5}};
        System.out.println(Arrays.toString(warehouseSummary(grid)));
    }
}
// Output: [49, 2, 1]
// Time: O(m*n), Space: O(1)
