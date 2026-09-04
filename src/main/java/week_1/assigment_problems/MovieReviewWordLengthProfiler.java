package week_1.assigment_problems;

public class MovieReviewWordLengthProfiler {

    public static void main(String[] args) {

        String review = "This movie was very entertaining";

        String[] words = review.split(" ");

        int totalLength = 0;
        int longestLength = 0;
        String longestWord = "";

        for (String word : words) {

            int length = word.length();
            totalLength += length;

            if (length > longestLength) {
                longestLength = length;
                longestWord = word;
            }
        }

        double averageLength = (double) totalLength / words.length;

        System.out.println("Number of words: " + words.length);
        System.out.println("Average word length: " + averageLength);
        System.out.println("Longest word: " + longestWord);
        System.out.println("Longest word length: " + longestLength);
    }
}
