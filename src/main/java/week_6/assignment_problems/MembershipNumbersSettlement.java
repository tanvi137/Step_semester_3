package week_6.assignment_problems;

class SettlementGymMember {

    private static int counter = 2000;
    private final String membershipNumber;

    private int feesPaid;

    public SettlementGymMember(int monthlyFee) {

        counter++;
        membershipNumber =
                "GYM-" + counter;
    }

    void payFee(int amount) {
        feesPaid += amount;
    }

    void payFee(int amount, String mode) {
        payFee(amount);
    }

    int getFeesPaid() {
        return feesPaid;
    }

    String getMembershipNumber() {
        return membershipNumber;
    }

    static boolean isValidReferralCode(String code) {

        if (code == null || code.length() != 4)
            return false;

        return code.charAt(0) == 'G'
                && Character.isDigit(code.charAt(1))
                && Character.isDigit(code.charAt(2))
                && Character.isUpperCase(code.charAt(3));
    }

    static int getMembersEnrolled() {
        return counter - 2000;
    }
}

class SettlementGroupClassMember
        extends SettlementGymMember {

    private String className;

    public SettlementGroupClassMember(
            int monthlyFee,
            String className) {

        super(monthlyFee);
        this.className = className;
    }
}

public class MembershipNumbersSettlement {

    static String processWeeklyCheckIn(
            SettlementGymMember[] members) {

        int processed = 0;
        int skipped = 0;
        int group = 0;
        int individual = 0;

        for (SettlementGymMember member : members) {

            if (member == null) {
                skipped++;
                continue;
            }

            processed++;

            if (member instanceof SettlementGroupClassMember)
                group++;
            else
                individual++;
        }

        return processed + " processed | " +
               skipped + " null skipped | " +
               group + " group | " +
               individual + " individual";
    }

    public static void main(String[] args) {

        SettlementGroupClassMember group =
                new SettlementGroupClassMember(
                    1500, "Zumba"
                );

        SettlementGymMember regular =
                new SettlementGymMember(1000);

        group.payFee(500);
        group.payFee(500, "UPI");

        System.out.println(
            group.getMembershipNumber()
        );

        System.out.println(
            group.getFeesPaid()
        );

        System.out.println(
            SettlementGymMember.isValidReferralCode("G45B")
        );

        System.out.println(
            SettlementGymMember.isValidReferralCode("G4B")
        );

        System.out.println(
            processWeeklyCheckIn(
                new SettlementGymMember[]{
                    group, null, regular
                }
            )
        );
    }
}
