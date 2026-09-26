package week_8.practice_problems;

abstract class Employee {
    protected String name;

    public Employee(String name) {
        this.name = name;
    }

    public abstract boolean isLeaveAllowed(int days);
}

class FullTimeEmployee extends Employee {
    public FullTimeEmployee(String name) {
        super(name);
    }

    public boolean isLeaveAllowed(int days) {
        return days <= 30;
    }
}

class PartTimeEmployee extends Employee {
    public PartTimeEmployee(String name) {
        super(name);
    }

    public boolean isLeaveAllowed(int days) {
        return days <= 10;
    }
}

class LeaveRequest {
    private Employee employee;
    private String dates;
    private String status = "Pending";

    public LeaveRequest(Employee employee, String dates) {
        this.employee = employee;
        this.dates = dates;
    }

    public void submit() {
        System.out.println("Leave request submitted for "
                + employee.name + " (" + dates + ").");
        System.out.println("Status: " + status);
    }

    public void approve() {
        if (!status.equals("Pending")) {
            System.out.println("Cannot approve a " + status + " request.");
            return;
        }

        status = "Approved";
        System.out.println(employee.name + "'s leave request (" + dates
                + ") approved.");
        System.out.println("Status: " + status);
    }

    public void reject() {
        if (!status.equals("Pending")) {
            System.out.println("Cannot reject a " + status + " request.");
            return;
        }

        status = "Rejected";
        System.out.println(employee.name + "'s leave request (" + dates
                + ") rejected.");
        System.out.println("Status: " + status);
    }

    public void changeToPending() {
        if (!status.equals("Pending")) {
            System.out.println("Cannot change leave request status from "
                    + status + " to Pending.");
        }
    }
}

public class EmployeeLeaveRequestWorkflow {
    public static void main(String[] args) {
        FullTimeEmployee john = new FullTimeEmployee("John");
        PartTimeEmployee jane = new PartTimeEmployee("Jane");

        LeaveRequest r1 =
                new LeaveRequest(john, "Jan 1-5");

        LeaveRequest r2 =
                new LeaveRequest(jane, "Feb 10-11");

        r1.submit();
        r1.approve();

        r2.submit();
        r2.reject();

        r1.changeToPending();
    }
}
