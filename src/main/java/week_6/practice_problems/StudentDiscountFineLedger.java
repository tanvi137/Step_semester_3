package week_6.practice_problems;

class FineLibraryMember {
    private int[] fineHistory = new int[10];
    private int fineCount;

    protected void chargeFine(int amount) {
        if (fineCount < fineHistory.length)
            fineHistory[fineCount++] = amount;
    }

    int[] getFineHistory() {
        int[] copy = new int[fineCount];

        for (int i = 0; i < fineCount; i++)
            copy[i] = fineHistory[i];

        return copy;
    }

    int getTotalFine() {
        int total = 0;

        for (int i = 0; i < fineCount; i++)
            total += fineHistory[i];

        return total;
    }
}

class FineStudentMember extends FineLibraryMember {

    @Override
    protected void chargeFine(int amount) {
        super.chargeFine(amount / 2);
    }
}

public class StudentDiscountFineLedger {

    public static void main(String[] args) {

        FineStudentMember s = new FineStudentMember();

        s.chargeFine(100);

        System.out.println("Total Fine: " + s.getTotalFine());

        int[] history = s.getFineHistory();
        history[0] = 999;

        System.out.println(
            "Actual Fine: " + s.getFineHistory()[0]
        );
    }
}
