package week_5.assignment_problems;

public final class LoanReceipt {

    private final String receiptId;
    private final String bookName;

    LoanReceipt(String receiptId, String bookName) {
        this.receiptId = receiptId;
        this.bookName = bookName;
    }

    void displayReceipt() {
        System.out.println("Receipt ID: " + receiptId);
        System.out.println("Book: " + bookName);
    }

    public static void main(String[] args) {

        LoanReceipt receipt =
                new LoanReceipt("LR501","Java Programming");

        receipt.displayReceipt();
    }
}
