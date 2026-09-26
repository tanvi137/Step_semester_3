package week_8.practice_problems;

abstract class Room {
    protected String number;

    public Room(String number) {
        this.number = number;
    }

    public String getNumber() {
        return number;
    }

    public abstract double calculatePrice(int nights);
}

class StandardRoom extends Room {
    public StandardRoom(String number) {
        super(number);
    }

    public double calculatePrice(int nights) {
        return nights * 100;
    }
}

class DeluxeRoom extends Room {
    public DeluxeRoom(String number) {
        super(number);
    }

    public double calculatePrice(int nights) {
        return nights * 180;
    }
}

class HotelCustomer {
    private String name;

    public HotelCustomer(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

class Reservation {
    private HotelCustomer customer;
    private Room room;
    private String dates;
    private boolean active = true;

    public Reservation(HotelCustomer customer, Room room, String dates) {
        this.customer = customer;
        this.room = room;
        this.dates = dates;
    }

    public boolean overlaps(String requestedDates) {
        return active && dates.equals(requestedDates);
    }

    public void cancel() {
        active = false;
        System.out.println("Reservation for " + customer.getName()
                + ", " + room.getClass().getSimpleName()
                + " " + room.getNumber()
                + " (" + dates + ") cancelled successfully.");
    }

    public Room getRoom() {
        return room;
    }
}

public class HotelBookingSystem {

    static boolean isAvailable(
            Room room, Reservation[] reservations, String dates) {

        for (Reservation r : reservations) {
            if (r != null &&
                    r.getRoom() == room &&
                    r.overlaps(dates)) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {

        HotelCustomer a = new HotelCustomer("Customer A");
        HotelCustomer c = new HotelCustomer("Customer C");

        Room standard = new StandardRoom("101");
        Room deluxe = new DeluxeRoom("201");

        Reservation[] reservations = new Reservation[10];

        String dates1 = "Jan 1-Jan 5";

        if (isAvailable(standard, reservations, dates1)) {
            System.out.println("Standard Room 101 is available from Jan 1 to Jan 5.");

            reservations[0] =
                    new Reservation(a, standard, dates1);

            System.out.println("Reservation confirmed for Customer A, "
                    + "Standard Room 101 (Jan 1-Jan 5).");

            System.out.printf("Price: $%.2f%n",
                    standard.calculatePrice(4));
        }

        if (!isAvailable(standard, reservations,
                "Jan 3-Jan 7")) {
            System.out.println(
                    "Standard Room 101 is not available from Jan 3 to Jan 7.");
        }

        reservations[0].cancel();

        reservations[1] =
                new Reservation(c, deluxe, "Feb 10-Feb 12");

        System.out.println("Reservation confirmed for Customer C, "
                + "Deluxe Room 201 (Feb 10-Feb 12).");

        System.out.printf("Price: $%.2f%n",
                deluxe.calculatePrice(2));
    }
}
