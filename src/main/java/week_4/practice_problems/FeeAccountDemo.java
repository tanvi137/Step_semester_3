package week_4.practice_problems;

class FeeAccount {

    public void pay(double amount) {
        System.out.println(
                "Paid in one go (day-scholar account)"
        );
    }
}

class HostelFeeAccount extends FeeAccount {

    @Override
    public void pay(double amount) {
        System.out.println(
                "Paid in two installments (hostel account)"
        );
    }
}

public class FeeAccountDemo {

    static int hostelCount = 0;
    static int dayScholarCount = 0;

    public static void processPayment(
            FeeAccount account,
            double amount) {

        if (account instanceof HostelFeeAccount) {

            HostelFeeAccount hostel =
                    (HostelFeeAccount) account;

            hostel.pay(amount);
            hostelCount++;

        } else {

            account.pay(amount);
            dayScholarCount++;
        }
    }

    public static void main(String[] args) {

        FeeAccount[] accounts = {
                new HostelFeeAccount(),
                new HostelFeeAccount(),
                new FeeAccount(),
                new FeeAccount()
        };

        for (FeeAccount account : accounts) {
            processPayment(account, 60000);
        }

        System.out.println(
                "Hostel accounts processed: " + hostelCount
                + " | Day-scholar accounts processed: "
                + dayScholarCount
        );
    }
}