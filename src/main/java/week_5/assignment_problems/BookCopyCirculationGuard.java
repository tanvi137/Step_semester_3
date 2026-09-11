package week_5.assignment_problems;

public class BookCopyCirculationGuard {

    private int copiesAvailable = 5;

    void issueBook() {
        if (copiesAvailable > 0) {
            copiesAvailable--;
        }
    }

    void returnBook() {
        copiesAvailable++;
    }

    int getCopiesAvailable() {
        return copiesAvailable;
    }

    public static void main(String[] args) {

        BookCopyCirculationGuard book =
                new BookCopyCirculationGuard();

        book.issueBook();
        book.issueBook();

        System.out.println(book.getCopiesAvailable());

        book.returnBook();

        System.out.println(book.getCopiesAvailable());
    }
}
