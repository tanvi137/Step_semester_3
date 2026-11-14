package week_12.practice_problems;

public class LeaderboardRanking {
    static class Participant {
        String name;
        int score;

        Participant(String name, int score) {
            this.name = name;
            this.score = score;
        }
    }

    static void sort(Participant[] a) {
        for (int i = 1; i < a.length; i++) {
            Participant key = a[i];
            int j = i - 1;
            while (j >= 0 && a[j].score < key.score) {
                a[j + 1] = a[j];
                j--;
            }
            a[j + 1] = key;
        }
    }

    static void printRanks(Participant[] a) {
        int rank = 0;
        for (int i = 0; i < a.length; i++) {
            if (i == 0 || a[i].score != a[i - 1].score)
                rank = i + 1;
            System.out.println(rank + " " + a[i].name + " " + a[i].score);
        }
    }

    public static void main(String[] args) {
        Participant[] a = {
            new Participant("Asha", 90),
            new Participant("Ravi", 85),
            new Participant("Neha", 90),
            new Participant("Kiran", 70)
        };
        sort(a);
        printRanks(a);
    }
}
// Stable insertion sort: O(n^2) worst, O(n) best
// Rank printing: O(n), Extra space: O(1)
