package week_6.assignment_problems;

class FeeGymMember {

    private int[] lateFeeHistory = new int[10];
    private int feeCount;

    protected void chargeLateFee(int amount) {

        if (feeCount < lateFeeHistory.length)
            lateFeeHistory[feeCount++] = amount;
    }

    int[] getLateFeeHistory() {

        int[] copy = new int[feeCount];

        for (int i = 0; i < feeCount; i++)
            copy[i] = lateFeeHistory[i];

        return copy;
    }

    int getTotalLateFees() {

        int total = 0;

        for (int i = 0; i < feeCount; i++)
            total += lateFeeHistory[i];

        return total;
    }
}

class FeePremiumMember extends FeeGymMember {

    @Override
    protected void chargeLateFee(int amount) {
        super.chargeLateFee(amount / 2);
    }
}

public class PremiumLoyaltyFeeLedger {

    public static void main(String[] args) {

        FeePremiumMember p =
                new FeePremiumMember();

        p.chargeLateFee(200);

        System.out.println(
            "Total Late Fees: " +
            p.getTotalLateFees()
        );

        int[] history = p.getLateFeeHistory();

        history[0] = 999;

        System.out.println(
            "Actual Fee: " +
            p.getLateFeeHistory()[0]
        );
    }
}
