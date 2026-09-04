package week_1.assigment_problems;

import java.util.Scanner;

public class TypingAccuracyChecker {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter original sentence: ");
        String original = scanner.nextLine();

        System.out.print("Enter typed sentence: ");
        String typed = scanner.nextLine();

        int minLength = Math.min(original.length(), typed.length());
        int correctCharacters = 0;

        for (int i = 0; i < minLength; i++) {
            if (original.charAt(i) == typed.charAt(i)) {
                correctCharacters++;
            }
        }

        double accuracy;

        if (original.length() == 0) {
            accuracy = typed.length() == 0 ? 100.0 : 0.0;
        } else {
            accuracy = (correctCharacters * 100.0) / original.length();
        }

        System.out.println("Correct characters: " + correctCharacters);
        System.out.printf("Typing Accuracy: %.2f%%%n", accuracy);

        scanner.close();
    }
}
