package week_12.assignment_problems;

public class MiddleSeatFinder {
    static class Node {
        int data;
        Node next;
        Node(int data) { this.data = data; }
    }

    static int middle(Node head) {
        Node slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow.data;
    }

    static Node create(int... values) {
        Node dummy = new Node(0), tail = dummy;
        for (int x : values) {
            tail.next = new Node(x);
            tail = tail.next;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        System.out.println("Middle: " + middle(create(11, 22, 33, 44, 55)));
        System.out.println("Middle: " + middle(create(11, 22, 33, 44, 55, 66)));
    }
}
// Time: O(n), Extra space: O(1)
// Fast pointer advances about n/2 times, two links per iteration
