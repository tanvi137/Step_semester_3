package week_1.assigment_problems;

import java.util.HashSet;
import java.util.Scanner;

public class SeatDuplicationChecker {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number of seats: ");
        int n = scanner.nextInt();

        HashSet<Integer> seats = new HashSet<>();
        boolean duplicateFound = false;

        System.out.println("Enter seat numbers:");

        for (int i = 0; i < n; i++) {

            int seatNumber = scanner.nextInt();

            if (!seats.add(seatNumber)) {
                duplicateFound = true;
            }
        }

        if (duplicateFound) {
            System.out.println("Duplicate seat number found.");
        } else {
            System.out.println("No duplicate seat numbers.");
        }

        scanner.close();
    }
}
