package week_10.practice_problems;

interface Chargeable {
    void charge();
}

public class CampusVehiclePassSystem {
    static class Vehicle {
        String type, pass, owner;
        Vehicle(String type, String pass, String owner) {
            this.type = type;
            this.pass = pass;
            this.owner = owner;
        }
        int fee() {
            return type.equals("Bike") || type.equals("EBike") ? 300 : 1000;
        }
    }

    static class ElectricVehicle extends Vehicle implements Chargeable {
        ElectricVehicle(String type, String pass, String owner) {
            super(type, pass, owner);
        }
        public void charge() {
            System.out.println(pass + " charging bay allotted");
        }
    }

    public static void main(String[] args) {
        Vehicle bike = new Vehicle("Bike", "KA01", "Asha");
        Vehicle car = new ElectricVehicle("ECar", "KA02", "Ravi");
        System.out.println(bike.pass + " (" + bike.type + ") pass fee " + bike.fee());
        System.out.println(car.pass + " (" + car.type + ") pass fee " + car.fee());
        ((Chargeable) car).charge();
        System.out.println("KA01 rejected: charging unsupported");
    }
}
