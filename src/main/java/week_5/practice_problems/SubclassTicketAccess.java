package week_5.practice_problems;

class Ticket {
    protected String seat = "B15";
    public String movie = "Jawan";
}

class VIPTicket extends Ticket {

    void showTicket() {
        System.out.println("Movie: " + movie);
        System.out.println("Seat: " + seat);
    }
}

public class SubclassTicketAccess {

    public static void main(String[] args) {
        VIPTicket vip = new VIPTicket();
        vip.showTicket();
    }
}
