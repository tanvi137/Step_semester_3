package week_5.practice_problems;

public class MovieBookingProfile {

    private String customerName;
    private boolean confirmed;
    private String otp;

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public boolean isConfirmed() {
        return confirmed;
    }

    public void setConfirmed(boolean confirmed) {
        this.confirmed = confirmed;
    }

    public void setOtp(String otp) {
        this.otp = otp;
    }

    public static void main(String[] args) {

        MovieBookingProfile profile = new MovieBookingProfile();

        profile.setCustomerName("Tanvi");
        profile.setConfirmed(true);
        profile.setOtp("1234");

        System.out.println(profile.getCustomerName());
        System.out.println(profile.isConfirmed());
    }
}
