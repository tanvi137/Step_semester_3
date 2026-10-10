package week_10.practice_problems;

import java.util.*;

public class StudentClubRegistrationManagement {
    static class Student {
        String roll, name;
        Student(String roll, String name) {
            this.roll = roll;
            this.name = name;
        }
        public boolean equals(Object o) {
            return o instanceof Student && roll.equals(((Student)o).roll);
        }
        public int hashCode() {
            return roll.hashCode();
        }
    }

    public static void main(String[] args) {
        Set<Student> members = new HashSet<>();
        System.out.println(members.add(new Student("21CS01", "Asha")) ? "Added" : "duplicate rejected");
        System.out.println(members.add(new Student("21CS01", "Asha")) ? "Added" : "duplicate rejected");
        System.out.println(members.add(new Student("21CS02", "Ravi")) ? "Added" : "duplicate rejected");
        System.out.println("member count " + members.size());
        System.out.println("contains: " + members.contains(new Student("21CS02", "Ravi")));
        System.out.println("contains: " + members.contains(new Student("21CS03", "Priya")));
    }
}
