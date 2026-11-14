package week_12.practice_problems;

public class SecretNoticeShifter {
    static String shiftNotice(String text, int k) {
        StringBuilder result = new StringBuilder();
        for (char c : text.toCharArray()) {
            if (c >= 'a' && c <= 'z')
                c = (char) ('a' + (c - 'a' + k) % 26);
            else if (c >= 'A' && c <= 'Z')
                c = (char) ('A' + (c - 'A' + k) % 26);
            result.append(c);
        }
        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(shiftNotice("Lab at 5 PM", 3));
        System.out.println(shiftNotice("xyz", 2));
    }
}
// Time: O(n), Extra space: O(n)
