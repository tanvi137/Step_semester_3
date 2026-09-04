package week_1.class_problems;

import java.util.Scanner;

public class ReverseCustomerName {

    public static String reverseName(String fullName) {

        String[] words = fullName.trim().split("\\s+");

        StringBuilder reversedName = new StringBuilder();

        for (int i = words.length - 1; i >= 0; i--) {
            reversedName.append(words[i]);

            if (i != 0) {
                reversedName.append(" ");
            }
        }

        return reversedName.toString();
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter customer's full name: ");
        String fullName = scanner.nextLine();

        String reversedName = reverseName(fullName);

        System.out.println("Reversed name: " + reversedName);

        scanner.close();
    }
}
