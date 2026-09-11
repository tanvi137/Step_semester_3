package week_5.practice_problems;

public class CineScreen {

    private int seatsAvailable;

    CineScreen(int seats) {
        seatsAvailable = seats;
    }

    void bookSeat() {
        if (seatsAvailable > 0) {
            seatsAvailable--;
            System.out.println("Seat booked.");
        } else {
            System.out.println("No seats available.");
        }
    }

    void cancelSeat() {
        seatsAvailable++;
        System.out.println("Booking cancelled.");
    }

    int getSeatsAvailable() {
        return seatsAvailable;
    }

    public static void main(String[] args) {

        CineScreen screen = new CineScreen(2);

        screen.bookSeat();
        screen.bookSeat();
        screen.bookSeat();

        System.out.println("Seats Left: " + screen.getSeatsAvailable());

        screen.cancelSeat();

        System.out.println("Seats Left: " + screen.getSeatsAvailable());
    }
}
