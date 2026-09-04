package week_2.assignment_problems;

public class WordReversalEncoder {

    public static String reverseWord(String word) {
        return new StringBuilder(word).reverse().toString();
    }

    public static void main(String[] args) {
        String word = "HELLO";

        System.out.println("Original: " + word);
        System.out.println("Reversed: " + reverseWord(word));
    }
}