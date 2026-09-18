package week_6.assignment_problems;

class GymMemberTree {
    protected int sessionsAttended;

    public GymMemberTree(String memberId, int monthlyFee) {
    }

    void attendSession() {
        sessionsAttended++;
    }

    int getSessionsAttended() {
        return sessionsAttended;
    }

    void displayInfo() {
        System.out.println(
            "Standard Member | Sessions: " +
            sessionsAttended
        );
    }
}

class PremiumMemberTree extends GymMemberTree {

    protected String trainerName;

    public PremiumMemberTree(
            String memberId,
            int monthlyFee,
            String trainerName) {

        super(memberId, monthlyFee);
        this.trainerName = trainerName;
    }

    @Override
    void displayInfo() {
        System.out.println(
            "Premium Member | Trainer: " +
            trainerName +
            " | Sessions: " +
            sessionsAttended
        );
    }
}

class EliteMemberTree extends PremiumMemberTree {

    private String lockerNumber;

    public EliteMemberTree(
            String memberId,
            int monthlyFee,
            String trainerName,
            String lockerNumber) {

        super(memberId, monthlyFee, trainerName);
        this.lockerNumber = lockerNumber;
    }

    @Override
    void displayInfo() {
        System.out.println(
            "Elite Member | Trainer: " +
            trainerName +
            " | Locker: " +
            lockerNumber +
            " | Sessions: " +
            sessionsAttended
        );
    }
}

class GroupClassMemberTree extends GymMemberTree {

    private String className;

    public GroupClassMemberTree(
            String memberId,
            int monthlyFee,
            String className) {

        super(memberId, monthlyFee);
        this.className = className;
    }

    @Override
    void displayInfo() {
        System.out.println(
            "Group Class Member | Class: " +
            className +
            " | Sessions: " +
            sessionsAttended
        );
    }
}

public class ThreeTiersGymMembership {

    static String classifyGeneration(GymMemberTree member) {

        if (member instanceof EliteMemberTree)
            return "Multilevel descendant (3 generations deep)";

        if (member instanceof GroupClassMemberTree)
            return "Hierarchical sibling (independent branch)";

        return "Base or premium member";
    }

    static int getTotalSessionsAttended(
            GymMemberTree[] members) {

        int total = 0;

        for (GymMemberTree member : members)
            total += member.getSessionsAttended();

        return total;
    }

    public static void main(String[] args) {

        GymMemberTree standard =
                new GymMemberTree("MEM1", 1000);

        PremiumMemberTree premium =
                new PremiumMemberTree(
                    "MEM2", 2000, "Coach Riya"
                );

        EliteMemberTree elite =
                new EliteMemberTree(
                    "MEM3", 3000,
                    "Coach Arjun", "L12"
                );

        GroupClassMemberTree group =
                new GroupClassMemberTree(
                    "MEM4", 1500, "Zumba"
                );

        premium.attendSession();
        premium.attendSession();
        premium.attendSession();

        elite.attendSession();
        elite.attendSession();

        group.attendSession();
        group.attendSession();
        group.attendSession();
        group.attendSession();

        standard.displayInfo();
        premium.displayInfo();
        elite.displayInfo();
        group.displayInfo();

        System.out.println(classifyGeneration(elite));
        System.out.println(classifyGeneration(group));

        System.out.println(
            "Total Sessions: " +
            getTotalSessionsAttended(
                new GymMemberTree[]{
                    premium, elite, group
                }
            )
        );
    }
}
