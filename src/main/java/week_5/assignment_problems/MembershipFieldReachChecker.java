package week_5.assignment_problems;

public class MembershipFieldReachChecker {

    private String memberId = "M101";
    String section = "CSE";
    protected double fee = 500;
    public String name = "Tanvi";

    void display() {
        System.out.println(memberId);
        System.out.println(section);
        System.out.println(fee);
        System.out.println(name);
    }

    public static void main(String[] args) {
        MembershipFieldReachChecker member =
                new MembershipFieldReachChecker();
        member.display();
    }
}
