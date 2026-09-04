package week_1.assigment_problems;

import java.util.HashSet;

public class SeatDuplicationChecker {

    public static void main(String[] args) {

        int[] seats = {101, 102, 103, 104, 102, 105};

        HashSet<Integer> uniqueSeats = new HashSet<>();

        for (int seat : seats) {
            if (!uniqueSeats.add(seat)) {
                System.out.println("Duplicate seat found: " + seat);
            }
        }
    }
}
