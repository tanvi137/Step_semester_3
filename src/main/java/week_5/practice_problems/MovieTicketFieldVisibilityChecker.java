package week_5.practice_problems;

public class MovieTicketFieldVisibilityChecker {

    private String movieName;
    int ticketPrice;
    protected String seatNumber;
    public String customerName;

    public MovieTicketFieldVisibilityChecker(String movieName, int ticketPrice,
                                              String seatNumber, String customerName) {
        this.movieName = movieName;
        this.ticketPrice = ticketPrice;
        this.seatNumber = seatNumber;
        this.customerName = customerName;
    }

    public void displayDetails() {
        System.out.println("Movie: " + movieName);
        System.out.println("Ticket Price: " + ticketPrice);
        System.out.println("Seat Number: " + seatNumber);
        System.out.println("Customer: " + customerName);
    }

    public static void main(String[] args) {
        MovieTicketFieldVisibilityChecker ticket =
                new MovieTicketFieldVisibilityChecker(
                        "Avengers", 250, "A12", "Tanvi"
                );

        ticket.displayDetails();
    }
}
