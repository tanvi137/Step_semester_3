package week_5.assignment_problems;

public class LibraryMemberJavaBeanSecurity {

    private String memberName;
    private String membershipId;
    private boolean premiumMember;

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public String getMembershipId() {
        return membershipId;
    }

    public void setMembershipId(String membershipId) {
        this.membershipId = membershipId;
    }

    public boolean isPremiumMember() {
        return premiumMember;
    }

    public void setPremiumMember(boolean premiumMember) {
        this.premiumMember = premiumMember;
    }

    public static void main(String[] args) {

        LibraryMemberJavaBeanSecurity member =
                new LibraryMemberJavaBeanSecurity();

        member.setMemberName("Tanvi");
        member.setMembershipId("LIB1001");
        member.setPremiumMember(true);

        System.out.println(member.getMemberName());
        System.out.println(member.getMembershipId());
        System.out.println(member.isPremiumMember());
    }
}
