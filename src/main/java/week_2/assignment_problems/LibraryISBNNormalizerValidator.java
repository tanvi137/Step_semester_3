package week_2.assignment_problems;

public class LibraryISBNNormalizerValidator {

    public static String normalizeISBN(String isbn) {
        return isbn.replaceAll("[^0-9]", "");
    }

    public static boolean isValidISBN(String isbn) {
        String normalized = normalizeISBN(isbn);

        return normalized.length() == 10 ||
               normalized.length() == 13;
    }

    public static void main(String[] args) {

        String[] isbnNumbers = {
                "978-0-306-40615-7",
                "0-306-40615-2",
                "12345"
        };

        for (String isbn : isbnNumbers) {

            String normalized = normalizeISBN(isbn);

            System.out.println("Original: " + isbn);
            System.out.println("Normalized: " + normalized);

            if (isValidISBN(isbn)) {
                System.out.println("Valid ISBN");
            } else {
                System.out.println("Invalid ISBN");
            }

            System.out.println();
        }
    }
}