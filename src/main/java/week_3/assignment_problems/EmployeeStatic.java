package week_3.assignment_problems;

public class EmployeeStatic {

    String empName;
    double salary;

    static String companyName = "Bright Horizon Technologies";
    static int employeeCount = 0;

    EmployeeStatic(String empName, double salary) {
        this.empName = empName;
        this.salary = salary;
        employeeCount++;
    }

    static void printCompanyInfo() {
        System.out.println(companyName);
        System.out.println("Employees on record: " + employeeCount);
    }

    public static void main(String[] args) {

        EmployeeStatic emp1 =
                new EmployeeStatic("Divya", 65000);

        EmployeeStatic emp2 =
                new EmployeeStatic("Arjun", 45000);

        EmployeeStatic emp3 =
                new EmployeeStatic("Priya", 55000);

        EmployeeStatic.printCompanyInfo();
    }
}
