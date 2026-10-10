package week_10.practice_problems;

public class PayrollRegisterSystem {
    static class Payslip {
        String name, type;
        int pay;
        Payslip(String name, String type, int pay) {
            this.name = name;
            this.type = type;
            this.pay = pay;
        }
        public String toString() {
            return "Payslip[name=" + name + ", type=" + type + ", pay=" + pay + "]";
        }
    }

    public static void main(String[] args) {
        Payslip[] slips = {
            new Payslip("Asha", "FullTime", 50000),
            new Payslip("Ravi", "PartTime", 80 * 300),
            new Payslip("Neha", "Intern", 15000)
        };
        int total = 0, best = 0;
        for (int i = 0; i < slips.length; i++) {
            System.out.println(slips[i]);
            total += slips[i].pay;
            if (slips[i].pay > slips[best].pay) best = i;
        }
        System.out.println("Total " + total);
        System.out.println("top earner " + slips[best].name);
    }
}
