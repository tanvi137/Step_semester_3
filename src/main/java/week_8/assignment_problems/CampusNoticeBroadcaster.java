package week_8.assignment_problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

interface NotificationChannel {
    void send(NoticeStudent student, String message);
}

class EmailChannel implements NotificationChannel {

    public void send(NoticeStudent student, String message) {
        System.out.println(
                "[Email → " + student.getName()
                + "] " + message);
    }
}

class SmsChannel implements NotificationChannel {

    public void send(NoticeStudent student, String message) {
        System.out.println(
                "[SMS → " + student.getName()
                + "] " + message);
    }
}

class AppChannel implements NotificationChannel {

    public void send(NoticeStudent student, String message) {
        System.out.println(
                "[App → " + student.getName()
                + "] " + message);
    }
}

class NoticeStudent {
    private String name;
    private String department;

    private List<NotificationChannel> channels =
            new ArrayList<>();

    public NoticeStudent(
            String name,
            String department) {

        this.name = name;
        this.department = department;
    }

    public String getName() {
        return name;
    }

    public String getDepartment() {
        return department;
    }

    public void addChannel(
            NotificationChannel channel) {

        channels.add(channel);
    }

    public List<NotificationChannel> getChannels() {
        return channels;
    }
}

class Notice {
    private String title;
    private List<String> departments;

    public Notice(
            String title,
            List<String> departments) {

        this.title = title;
        this.departments = departments;
    }

    public boolean isValid() {
        return title != null &&
                !title.trim().isEmpty() &&
                departments != null &&
                !departments.isEmpty();
    }

    public String getTitle() {
        return title;
    }

    public List<String> getDepartments() {
        return departments;
    }
}

class NoticeBoard {
    private List<NoticeStudent> students =
            new ArrayList<>();

    public void addStudent(NoticeStudent student) {
        students.add(student);
    }

    public void post(Notice notice) {

        if (!notice.isValid()) {
            System.out.println(
                    "Cannot post notice: At least one target department is required.");
            return;
        }

        System.out.println(
                "Notice '" + notice.getTitle()
                + "' posted to "
                + String.join(", ",
                        notice.getDepartments()) + ".");

        for (NoticeStudent student : students) {

            if (notice.getDepartments()
                    .contains(student.getDepartment())) {

                for (NotificationChannel channel :
                        student.getChannels()) {

                    channel.send(
                            student,
                            notice.getTitle());
                }
            }
        }
    }
}

public class CampusNoticeBroadcaster {
    public static void main(String[] args) {

        NoticeStudent asha =
                new NoticeStudent("Asha", "CSE");

        asha.addChannel(new EmailChannel());
        asha.addChannel(new AppChannel());

        NoticeStudent ravi =
                new NoticeStudent("Ravi", "ECE");

        ravi.addChannel(new SmsChannel());

        NoticeBoard board = new NoticeBoard();

        board.addStudent(asha);
        board.addStudent(ravi);

        board.post(
                new Notice(
                        "Lab Closed Tomorrow",
                        Arrays.asList("CSE")));

        board.post(
                new Notice(
                        "Fee Deadline Extended",
                        Arrays.asList("CSE", "ECE")));

        board.post(
                new Notice(
                        "Sports Day",
                        new ArrayList<>()));
    }
}
