package week_6.assignment_problems;

class GymMemberBase {
    protected String memberId;
    protected int monthlyFee;
    private int sessionsAttended;

    public GymMemberBase(String memberId, int monthlyFee) {

        if (memberId == null || memberId.trim().length() < 4)
            throw new IllegalArgumentException("Invalid member ID");

        this.memberId = memberId;
        this.monthlyFee = monthlyFee;
    }

    void attendSession() {
        sessionsAttended++;
    }

    int getSessionsAttended() {
        return sessionsAttended;
    }
}

class PremiumGymMember extends GymMemberBase {

    private String trainerName;

    public PremiumGymMember(
            String memberId,
            int monthlyFee,
            String trainerName) {

        super(memberId, monthlyFee);
        this.trainerName = trainerName;
    }
}

public class GymMembershipFoundation {

    static String signUpBatch(
            String[] memberIds,
            int monthlyFee) {

        int signedUp = 0;
        int rejected = 0;

        for (String id : memberIds) {

            try {
                new GymMemberBase(id, monthlyFee);
                signedUp++;
            } catch (IllegalArgumentException e) {
                rejected++;
            }
        }

        return "Signed Up: " + signedUp +
               " | Rejected: " + rejected;
    }

    public static void main(String[] args) {

        PremiumGymMember p =
                new PremiumGymMember(
                    "MEM01", 2000, "Coach Riya"
                );

        p.attendSession();
        p.attendSession();

        System.out.println(
            "Sessions: " + p.getSessionsAttended()
        );

        System.out.println(
            signUpBatch(
                new String[]{
                    "MEM1", "GM1", "MEM2", " ", "MEM3"
                },
                1000
            )
        );
    }
}
