package week_8.assignment_problems;

abstract class Assignment {
    protected String title;
    protected int maxMarks;
    protected String dueDate;

    public Assignment(String title, int maxMarks, String dueDate) {
        this.title = title;
        this.maxMarks = maxMarks;
        this.dueDate = dueDate;
    }

    public abstract double applyLatePenalty(
            double marks, int lateDays);
}

class CodingAssignment extends Assignment {

    public CodingAssignment(
            String title, int maxMarks, String dueDate) {
        super(title, maxMarks, dueDate);
    }

    public double applyLatePenalty(
            double marks, int lateDays) {

        return marks * Math.pow(0.90, lateDays);
    }
}

class WrittenAssignment extends Assignment {

    public WrittenAssignment(
            String title, int maxMarks, String dueDate) {
        super(title, maxMarks, dueDate);
    }

    public double applyLatePenalty(
            double marks, int lateDays) {

        return marks * Math.pow(0.80, lateDays);
    }
}

class SubmissionStudent {
    private String name;

    public SubmissionStudent(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

class Submission {
    private SubmissionStudent student;
    private Assignment assignment;
    private String submissionDate;
    private String status = "Submitted";

    public Submission(
            SubmissionStudent student,
            Assignment assignment,
            String submissionDate,
            int lateDays) {

        this.student = student;
        this.assignment = assignment;
        this.submissionDate = submissionDate;

        System.out.println(student.getName()
                + "'s submission for '"
                + assignment.title
                + "' received ("
                + (lateDays == 0 ? "on time"
                                  : lateDays + " days late")
                + ").");

        System.out.println("Status: " + status);
    }

    public void grade(double marks, int lateDays) {

        if (!status.equals("Submitted")) {
            System.out.println("Cannot grade this submission.");
            return;
        }

        double finalMarks =
                assignment.applyLatePenalty(marks, lateDays);

        status = "Graded";

        System.out.printf(
                "%s graded: %.0f/%d.%n",
                student.getName(),
                finalMarks,
                assignment.maxMarks);

        System.out.println("Status: " + status);
    }

    public void resubmit() {
        if (status.equals("Graded")) {
            System.out.println(
                    "Cannot resubmit: '"
                    + assignment.title
                    + "' has already been graded.");
        }
    }
}

public class AssignmentSubmissionPortal {
    public static void main(String[] args) {

        CodingAssignment coding =
                new CodingAssignment(
                        "Linked List Lab", 50, "Mar 10");

        WrittenAssignment written =
                new WrittenAssignment(
                        "Design Essay", 50, "Mar 12");

        SubmissionStudent asha = new SubmissionStudent("Asha");
        SubmissionStudent ravi = new SubmissionStudent("Ravi");

        Submission s1 =
                new Submission(
                        asha, coding, "Mar 10", 0);

        Submission s2 =
                new Submission(
                        ravi, written, "Mar 14", 2);

        s1.grade(45, 0);
        s2.grade(40, 2);

        s1.resubmit();
    }
}
