package week_1.assigment_problems;

public class TypingAccuracyChecker {

    public static void main(String[] args) {

        String original = "Java programming is easy";
        String typed = "Java programming is easy";

        int correct = 0;
        int length = Math.min(original.length(), typed.length());

        for (int i = 0; i < length; i++) {
            if (original.charAt(i) == typed.charAt(i)) {
                correct++;
            }
        }

        double accuracy = (correct * 100.0) / original.length();

        System.out.println("Correct characters: " + correct);
        System.out.println("Typing accuracy: " + accuracy + "%");
    }
}
