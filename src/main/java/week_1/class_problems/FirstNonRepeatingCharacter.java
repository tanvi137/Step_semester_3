package week_1.class_problems;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class FirstNonRepeatingCharacter {

    public static Character findFirstNonRepeating(String text) {

        HashMap<Character, Integer> frequencyMap = new HashMap<>();

        // Count frequency of each character
        for (char ch : text.toCharArray()) {
            frequencyMap.put(ch, frequencyMap.getOrDefault(ch, 0) + 1);
        }

        // Find the first character with frequency 1
        for (char ch : text.toCharArray()) {
            if (frequencyMap.get(ch) == 1) {
                return ch;
            }
        }

        return null;
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String text = scanner.nextLine();

        Character result = findFirstNonRepeating(text);

        if (result == null) {
            System.out.println("First non-repeating character: None");
        } else {
            System.out.println("First non-repeating character: " + result);
        }

        scanner.close();
    }
}
