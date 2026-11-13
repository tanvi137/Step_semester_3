package week_11.assignment_problems;

public class ContestLeaderboard {
    static class Entry {
        String name;
        int marks;
        Entry(String name, int marks) {
            this.name = name;
            this.marks = marks;
        }
        public String toString() { return name + " " + marks; }
    }

    static Entry[] leaderboard(Entry[] entries) {
        int[] count = new int[101];
        for (Entry e : entries) {
            if (e.marks < 0 || e.marks > 100)
                throw new IllegalArgumentException("Marks must be 0-100");
            count[100 - e.marks]++;
        }

        for (int i = 1; i < count.length; i++)
            count[i] += count[i - 1];

        Entry[] result = new Entry[entries.length];
        for (int i = entries.length - 1; i >= 0; i--) {
            Entry e = entries[i];
            result[--count[100 - e.marks]] = e;
        }
        return result;
    }

    public static void main(String[] args) {
        Entry[] entries = {
            new Entry("Asha", 90), new Entry("Ravi", 75),
            new Entry("Neha", 90), new Entry("Kiran", 100),
            new Entry("Meera", 75)
        };
        for (Entry e : leaderboard(entries))
            System.out.println(e);
    }
}
// Time: O(n + 101), Extra space: O(n + 101), Stable: Yes
