package week_1.class_problems;

import java.util.HashMap;

public class FirstNonRepeatingCharacter {

    public static void main(String[] args) {

        String input = "swiss";
        HashMap<Character, Integer> frequency = new HashMap<>();

        for (char ch : input.toCharArray()) {
            frequency.put(ch, frequency.getOrDefault(ch, 0) + 1);
        }

        for (char ch : input.toCharArray()) {
            if (frequency.get(ch) == 1) {
                System.out.println("First non-repeating character: " + ch);
                return;
            }
        }

        System.out.println("No non-repeating character found.");
    }
}
