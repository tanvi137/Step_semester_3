package week_8.assignment_problems;

interface WashType {
    int getDuration();
    double getCharge();
    String getName();
}

class QuickWash implements WashType {
    public int getDuration() {
        return 30;
    }

    public double getCharge() {
        return 20;
    }

    public String getName() {
        return "Quick";
    }
}

class NormalWash implements WashType {
    public int getDuration() {
        return 45;
    }

    public double getCharge() {
        return 30;
    }

    public String getName() {
        return "Normal";
    }
}

class HeavyWash implements WashType {
    public int getDuration() {
        return 60;
    }

    public double getCharge() {
        return 45;
    }

    public String getName() {
        return "Heavy";
    }
}

class LaundryStudent {
    private String name;

    public LaundryStudent(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

class WashCycle {
    private LaundryStudent student;
    private WashingMachine machine;
    private WashType washType;

    public WashCycle(
            LaundryStudent student,
            WashingMachine machine,
            WashType washType) {

        this.student = student;
        this.machine = machine;
        this.washType = washType;
    }

    public void start() {
        if (!machine.isFree()) {
            System.out.println("Machine " + machine.getId()
                    + " is currently busy.");
            return;
        }

        machine.startWash();

        System.out.println(washType.getName()
                + " wash started on "
                + machine.getId()
                + " for " + student.getName()
                + " (" + washType.getDuration() + " min).");

        System.out.printf("Charge: ₹%.2f%n",
                washType.getCharge());
    }

    public void complete() {
        machine.completeWash();

        System.out.println("Machine "
                + machine.getId()
                + " cycle completed.");

        System.out.println("Machine "
                + machine.getId()
                + " is now free.");
    }
}

class WashingMachine {
    private String id;
    private boolean free = true;

    public WashingMachine(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public boolean isFree() {
        return free;
    }

    public void startWash() {
        if (free)
            free = false;
    }

    public void completeWash() {
        free = true;
    }
}

public class HostelLaundryQueue {
    public static void main(String[] args) {

        LaundryStudent asha = new LaundryStudent("Asha");
        LaundryStudent ravi = new LaundryStudent("Ravi");
        LaundryStudent neha = new LaundryStudent("Neha");

        WashingMachine m1 = new WashingMachine("M1");
        WashingMachine m2 = new WashingMachine("M2");

        WashCycle quick =
                new WashCycle(asha, m1, new QuickWash());

        quick.start();

        new WashCycle(ravi, m1, new HeavyWash()).start();

        new WashCycle(ravi, m2, new HeavyWash()).start();

        quick.complete();

        new WashCycle(neha, m1, new NormalWash()).start();
    }
}
