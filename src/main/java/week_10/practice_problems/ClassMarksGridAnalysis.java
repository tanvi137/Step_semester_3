package week_10.practice_problems;

public class ClassMarksGridAnalysis {
    public static void main(String[] args) {
        String[] names = {"Asha", "Ravi", "Neha"};
        int[][] marks = {{78,85,90}, {88,92,79}, {65,70,95}};
        int[] totals = new int[names.length];
        int[] subjects = new int[3];
        int topper = 0;

        for (int i = 0; i < marks.length; i++) {
            for (int j = 0; j < 3; j++) {
                totals[i] += marks[i][j];
                subjects[j] += marks[i][j];
            }
            if (totals[i] > totals[topper]) topper = i;
            System.out.println("Total " + names[i] + " " + totals[i]);
        }

        System.out.printf("averages %.2f, %.2f, %.2f%n",
                subjects[0]/3.0, subjects[1]/3.0, subjects[2]/3.0);
        System.out.println("topper " + names[topper] + " (" + totals[topper] + ")");
    }
}
