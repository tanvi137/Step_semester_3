package week_8.practice_problems;

abstract class Vehicle {
    private String name;
    private boolean available = true;

    public Vehicle(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public boolean isAvailable() {
        return available;
    }

    protected void setAvailable(boolean available) {
        this.available = available;
    }

    public abstract double calculateCharge(int days);

    public void rent() {
        setAvailable(false);
    }

    public void returned() {
        setAvailable(true);
    }
}

class Sedan extends Vehicle {
    public Sedan(String name) {
        super(name);
    }

    public double calculateCharge(int days) {
        return days * 50;
    }
}

class SUV extends Vehicle {
    public SUV(String name) {
        super(name);
    }

    public double calculateCharge(int days) {
        return days * 80;
    }
}

class RentalCustomer {
    private String name;

    public RentalCustomer(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

class Rental {
    private Vehicle vehicle;
    private RentalCustomer customer;
    private int days;

    public Rental(Vehicle vehicle, RentalCustomer customer, int days) {
        this.vehicle = vehicle;
        this.customer = customer;
        this.days = days;
    }

    public void start() {
        if (!vehicle.isAvailable()) {
            System.out.println(vehicle.getName() + " is currently unavailable.");
            return;
        }

        vehicle.rent();
        System.out.println(vehicle.getName() + " rented successfully by "
                + customer.getName() + ".");
        System.out.printf("Rental charge: $%.2f%n",
                vehicle.calculateCharge(days));
    }

    public void returned() {
        vehicle.returned();
        System.out.println(vehicle.getName() + " returned by "
                + customer.getName() + ".");
    }
}

public class VehicleRentalSystem {
    public static void main(String[] args) {
        RentalCustomer c1 = new RentalCustomer("Customer 1");
        RentalCustomer c2 = new RentalCustomer("Customer 2");
        RentalCustomer c3 = new RentalCustomer("Customer 3");

        Vehicle sedan = new Sedan("Sedan A");
        Vehicle suv = new SUV("SUV B");

        new Rental(sedan, c1, 3).start();
        new Rental(sedan, c2, 2).start();

        new Rental(sedan, c1, 3).returned();

        new Rental(suv, c3, 5).start();
    }
}
