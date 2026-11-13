package week_11.assignment_problems;

public class PlacementCutoff {
    static int kthHighest(int[] marks, int k) {
        if (k < 1 || k > marks.length)
            throw new IllegalArgumentException("Invalid k");
        int target = marks.length - k;
        int left = 0, right = marks.length - 1;

        while (left <= right) {
            int pivot = partition(marks, left, right);
            if (pivot == target) return marks[pivot];
            if (pivot < target) left = pivot + 1;
            else right = pivot - 1;
        }
        throw new IllegalStateException("Selection failed");
    }

    static int partition(int[] a, int left, int right) {
        int pivot = a[right], i = left;
        for (int j = left; j < right; j++) {
            if (a[j] <= pivot) {
                int temp = a[i]; a[i] = a[j]; a[j] = temp;
                i++;
            }
        }
        int temp = a[i]; a[i] = a[right]; a[right] = temp;
        return i;
    }

    public static void main(String[] args) {
        System.out.println(kthHighest(new int[]{72, 95, 60, 88, 79}, 2));
        System.out.println(kthHighest(new int[]{50, 90, 90, 70}, 2));
    }
}
// Time: O(n) average, O(n^2) worst
// Extra space: O(1), Stable: No
