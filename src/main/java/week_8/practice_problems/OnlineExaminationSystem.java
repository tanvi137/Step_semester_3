package week_8.practice_problems;

abstract class Question {
    protected String text;
    protected int points;

    public Question(String text, int points) {
        this.text = text;
        this.points = points;
    }

    public abstract boolean evaluate(String answer);
}

class MultipleChoiceQuestion extends Question {
    private String correctAnswer;

    public MultipleChoiceQuestion(String text, String correctAnswer, int points) {
        super(text, points);
        this.correctAnswer = correctAnswer;
    }

    public boolean evaluate(String answer) {
        return correctAnswer.equalsIgnoreCase(answer);
    }
}

class TrueFalseQuestion extends Question {
    private boolean correctAnswer;

    public TrueFalseQuestion(String text, boolean correctAnswer, int points) {
        super(text, points);
        this.correctAnswer = correctAnswer;
    }

    public boolean evaluate(String answer) {
        return Boolean.parseBoolean(answer) == correctAnswer;
    }
}

class ExamStudent {
    private String name;

    public ExamStudent(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

class Examination {
    private String name;
    private Question[] questions;

    public Examination(String name, Question[] questions) {
        this.name = name;
        this.questions = questions;
    }

    public String getName() {
        return name;
    }

    public Question[] getQuestions() {
        return questions;
    }
}

class Attempt {
    private ExamStudent student;
    private Examination examination;
    private String[] answers;
    private boolean submitted;

    public Attempt(ExamStudent student, Examination examination) {
        this.student = student;
        this.examination = examination;
        answers = new String[examination.getQuestions().length];
    }

    public void answer(int index, String answer) {
        if (submitted) {
            System.out.println("Cannot change answers for a submitted examination.");
            return;
        }

        answers[index] = answer;
        System.out.println("Answer recorded for Question " + (index + 1) + ".");
    }

    public void submit() {
        submitted = true;

        int total = 0;
        int max = 0;

        System.out.println(examination.getName()
                + " submitted by " + student.getName() + ".");

        Question[] questions = examination.getQuestions();

        for (int i = 0; i < questions.length; i++) {
            max += questions[i].points;

            boolean correct =
                    questions[i].evaluate(answers[i]);

            if (correct) {
                total += questions[i].points;
                System.out.println("Question " + (i + 1)
                        + ": Correct (" + questions[i].points + " points)");
            } else {
                System.out.println("Question " + (i + 1)
                        + ": Incorrect (0 points)");
            }
        }

        System.out.println("Total score: " + total + "/" + max);
    }
}

public class OnlineExaminationSystem {
    public static void main(String[] args) {

        ExamStudent student = new ExamStudent("Student 1");

        Question[] questions = {
            new MultipleChoiceQuestion(
                    "Choose the correct option", "C", 5),
            new TrueFalseQuestion(
                    "Java is an OOP language", false, 5)
        };

        Examination exam =
                new Examination("Exam A", questions);

        System.out.println("Exam A started by Student 1.");

        Attempt attempt =
                new Attempt(student, exam);

        attempt.answer(0, "C");
        attempt.answer(1, "True");

        attempt.submit();

        attempt.answer(0, "A");
    }
}
