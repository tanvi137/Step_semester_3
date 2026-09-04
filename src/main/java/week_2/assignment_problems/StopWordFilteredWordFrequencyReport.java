package week_2.assignment_problems;

import java.util.*;

public class StopWordFilteredWordFrequencyReport {

    public static void main(String[] args) {

        String text = "Java is a programming language and Java is easy to learn";

        Set<String> stopWords = new HashSet<>(
                Arrays.asList("is", "a", "and", "to")
        );

        Map<String, Integer> frequency = new LinkedHashMap<>();

        String[] words = text.toLowerCase().split("\\s+");

        for (String word : words) {
            if (!stopWords.contains(word)) {
                frequency.put(word, frequency.getOrDefault(word, 0) + 1);
            }
        }

        System.out.println("Word Frequency Report:");

        for (Map.Entry<String, Integer> entry : frequency.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }
}