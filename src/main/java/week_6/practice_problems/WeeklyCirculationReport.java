package week_6.practice_problems;

class ReportLibraryMember {
    protected int books;

    public void displayInfo() {
        System.out.print("General | Books: " + books);
    }

    public int getBooksBorrowed() {
        return books;
    }
}

class ReportStudentMember extends ReportLibraryMember {
    private String course;

    ReportStudentMember(String course) {
        this.course = course;
    }

    @Override
    public void displayInfo() {
        System.out.print(
            "Student | Course: " + course +
            " | Books: " + books
        );
    }

    String getCourse() {
        return course;
    }
}

public class WeeklyCirculationReport {

    static String batchPrint(ReportLibraryMember[] members) {

        StringBuilder result = new StringBuilder();

        for (ReportLibraryMember member : members) {

            member.displayInfo();

            if (member instanceof ReportStudentMember) {
                ReportStudentMember student =
                        (ReportStudentMember) member;

                result.append(
                    "Student | Course: " +
                    student.getCourse() +
                    " | Books: " +
                    student.getBooksBorrowed()
                );
            } else {
                result.append(
                    "General | Books: " +
                    member.getBooksBorrowed()
                );
            }

            result.append(" | ");
        }

        return result.toString();
    }

    public static void main(String[] args) {

        ReportLibraryMember general =
                new ReportLibraryMember();

        ReportStudentMember student =
                new ReportStudentMember("ECE");

        ReportLibraryMember[] members =
                {general, student};

        System.out.println(batchPrint(members));
    }
}
