package week_6.assignment_problems;

class AttendanceGymMember {

    protected int sessionsAttended;

    void attendSession() {
        sessionsAttended++;
    }

    void displayInfo() {
        System.out.print(
            "Standard | Sessions: " +
            sessionsAttended
        );
    }
}

class AttendancePremiumMember
        extends AttendanceGymMember {

    private String trainerName;

    AttendancePremiumMember(String trainerName) {
        this.trainerName = trainerName;
    }

    String getTrainerName() {
        return trainerName;
    }

    @Override
    void displayInfo() {
        System.out.print(
            "Premium | Trainer: " +
            trainerName +
            " | Sessions: " +
            sessionsAttended
        );
    }
}

public class MonthlyAttendanceAnnouncer {

    static String batchPrint(
            AttendanceGymMember[] members) {

        StringBuilder result =
                new StringBuilder();

        for (AttendanceGymMember member : members) {

            member.displayInfo();

            if (member instanceof AttendancePremiumMember) {

                AttendancePremiumMember premium =
                        (AttendancePremiumMember) member;

                result.append(
                    "Premium | Trainer: " +
                    premium.getTrainerName() +
                    " | Sessions: " +
                    member.sessionsAttended +
                    " [Trainer via downcast: " +
                    premium.getTrainerName() +
                    "] | "
                );

            } else {

                result.append(
                    "Standard | Sessions: " +
                    member.sessionsAttended +
                    " | "
                );
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {

        AttendanceGymMember standard =
                new AttendanceGymMember();

        AttendancePremiumMember premium =
                new AttendancePremiumMember(
                    "Coach Riya"
                );

        System.out.println(
            batchPrint(
                new AttendanceGymMember[]{
                    standard, premium
                }
            )
        );
    }
}
