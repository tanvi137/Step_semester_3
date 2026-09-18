package week_6.practice_problems;

class AuditLibraryMember {
    private static int counter = 100;
    private final String memberNumber;

    private int booksBorrowed;

    public AuditLibraryMember(int borrowLimit) {
        counter++;
        memberNumber = "LIB-" + counter;
    }

    void borrowBook() {
        booksBorrowed++;
    }

    void borrowBook(String genre) {
        borrowBook();
    }

    int getBooksBorrowed() {
        return booksBorrowed;
    }

    String getMemberNumber() {
        return memberNumber;
    }

    static boolean isValidRenewalCode(String code) {

        if (code == null || code.length() != 4)
            return false;

        return code.charAt(0) == 'R'
                && Character.isDigit(code.charAt(1))
                && Character.isDigit(code.charAt(2))
                && Character.isUpperCase(code.charAt(3));
    }

    static int getMembersEnrolled() {
        return counter - 100;
    }
}

class AuditFacultyMember extends AuditLibraryMember {

    private String department;

    public AuditFacultyMember(int borrowLimit, String department) {
        super(borrowLimit);
        this.department = department;
    }
}

public class MembershipNumbersAudit {

    static String processNightlyAudit(
            AuditLibraryMember[] members) {

        int processed = 0;
        int skipped = 0;
        int faculty = 0;
        int regular = 0;

        for (AuditLibraryMember member : members) {

            if (member == null) {
                skipped++;
                continue;
            }

            processed++;

            if (member instanceof AuditFacultyMember)
                faculty++;
            else
                regular++;
        }

        return processed + " processed | " +
               skipped + " null skipped | " +
               faculty + " faculty | " +
               regular + " regular";
    }

    public static void main(String[] args) {

        AuditFacultyMember faculty =
                new AuditFacultyMember(5, "Physics");

        AuditLibraryMember regular =
                new AuditLibraryMember(3);

        AuditLibraryMember[] members =
                {faculty, null, regular};

        System.out.println(faculty.getMemberNumber());
        System.out.println(
            AuditLibraryMember.getMembersEnrolled()
        );

        System.out.println(
            AuditLibraryMember.isValidRenewalCode("R12A")
        );

        System.out.println(
            AuditLibraryMember.isValidRenewalCode("R1A")
        );

        faculty.borrowBook();
        faculty.borrowBook("Fiction");

        System.out.println(
            processNightlyAudit(members)
        );
    }
}
