package week_5.practice_problems;

public final class BookingReceipt {

    private final String bookingId;
    private final String movieName;

    BookingReceipt(String bookingId, String movieName) {
        this.bookingId = bookingId;
        this.movieName = movieName;
    }

    void displayReceipt() {
        System.out.println("Booking ID: " + bookingId);
        System.out.println("Movie: " + movieName);
    }

    public static void main(String[] args) {

        BookingReceipt receipt =
                new BookingReceipt("BK101","Pushpa 2");

        receipt.displayReceipt();
    }
}
