package week_1.class_problems;

public class ReverseCustomerName {

    public static void main(String[] args) {

        String name = "Tanvi Gupta";
        String reversed = "";

        for (int i = name.length() - 1; i >= 0; i--) {
            reversed += name.charAt(i);
        }

        System.out.println("Original name: " + name);
        System.out.println("Reversed name: " + reversed);
    }
}
