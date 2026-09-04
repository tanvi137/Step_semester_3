package week_1.assigment_problems;

import java.util.Scanner;

public class MovieReviewWordLengthProfiler {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter movie review: ");
        String review = scanner.nextLine().trim();

        if (review.isEmpty()) {
            System.out.println("No review entered.");
            scanner.close();
            return;
        }

        String[] words = review.split("\\s+");

        int totalLength = 0;
        int shortestLength = words[0].length();
        int longestLength = words[0].length();

        String shortestWord = words[0];
        String longestWord = words[0];

        for (String word : words) {

            int length = word.length();
            totalLength += length;

            if (length < shortestLength) {
                shortestLength = length;
                shortestWord = word;
            }

            if (length > longestLength) {
                longestLength = length;
                longestWord = word;
            }
        }

        double averageLength = (double) totalLength / words.length;

        System.out.println("Total Words: " + words.length);
        System.out.println("Average Word Length: " +
                String.format("%.2f", averageLength));
        System.out.println("Shortest Word: " + shortestWord +
                " (" + shortestLength + " characters)");
        System.out.println("Longest Word: " + longestWord +
                " (" + longestLength + " characters)");

        scanner.close();
    }
}
