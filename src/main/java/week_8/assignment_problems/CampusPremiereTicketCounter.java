package week_8.assignment_problems;

import java.util.ArrayList;

interface Seat {
    String getId();
    double getPrice();
}

class RegularSeat implements Seat {
    private String id;

    public RegularSeat(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public double getPrice() {
        return 150;
    }
}

class PremiumSeat implements Seat {
    private String id;

    public PremiumSeat(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public double getPrice() {
        return 250;
    }
}

class ReclinerSeat implements Seat {
    private String id;

    public ReclinerSeat(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public double getPrice() {
        return 400;
    }
}

class TicketCustomer {
    private String name;

    public TicketCustomer(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

class Show {
    private String time;
    private ArrayList<String> bookedSeats =
            new ArrayList<>();

    public Show(String time) {
        this.time = time;
    }

    public boolean isAvailable(String seatId) {
        return !bookedSeats.contains(seatId);
    }

    public boolean bookSeat(String seatId) {
        if (!isAvailable(seatId))
            return false;

        bookedSeats.add(seatId);
        return true;
    }

    public void releaseSeat(String seatId) {
        bookedSeats.remove(seatId);
    }

    public String getTime() {
        return time;
    }
}

class Booking {
    private TicketCustomer customer;
    private Show show;
    private ArrayList<Seat> seats =
            new ArrayList<>();

    private boolean cancelled;

    public Booking(TicketCustomer customer, Show show) {
        this.customer = customer;
        this.show = show;
    }

    public void addSeat(Seat seat) {

        if (seats.size() >= 6) {
            System.out.println(
                    "Cannot book more than 6 seats.");
            return;
        }

        if (!show.bookSeat(seat.getId())) {
            System.out.println("Seat "
                    + seat.getId()
                    + " is already booked for this show.");
            return;
        }

        seats.add(seat);
    }

    public void confirm() {
        if (seats.isEmpty())
            return;

        System.out.print("Booking confirmed for "
                + customer.getName() + ": ");

        for (Seat seat : seats)
            System.out.print(seat.getId() + " ");

        System.out.printf("%nTotal: ₹%.2f%n", total());
    }

    public double total() {
        double total = 0;

        for (Seat seat : seats)
            total += seat.getPrice();

        return total;
    }

    public void cancel() {
        if (cancelled)
            return;

        for (Seat seat : seats)
            show.releaseSeat(seat.getId());

        cancelled = true;

        System.out.println(
                customer.getName()
                + "'s booking cancelled.");

        System.out.println(
                "Seats released.");
    }
}

public class CampusPremiereTicketCounter {
    public static void main(String[] args) {

        Show show = new Show("7 PM");

        TicketCustomer asha = new TicketCustomer("Asha");
        TicketCustomer ravi = new TicketCustomer("Ravi");
        TicketCustomer neha = new TicketCustomer("Neha");

        Booking a = new Booking(asha, show);

        a.addSeat(new RegularSeat("A1"));
        a.addSeat(new RegularSeat("A2"));
        a.addSeat(new PremiumSeat("F5"));

        a.confirm();

        Booking r = new Booking(ravi, show);

        r.addSeat(new RegularSeat("A2"));
        r.addSeat(new ReclinerSeat("R1"));

        r.confirm();

        a.cancel();

        Booking n = new Booking(neha, show);

        n.addSeat(new RegularSeat("A2"));
        n.confirm();
    }
}
