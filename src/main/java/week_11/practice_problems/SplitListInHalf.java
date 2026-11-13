package week_11.practice_problems;

public class SplitListInHalf {
    static class Node {
        int data;
        Node next;
        Node(int data) { this.data = data; }
    }

    static Node splitListInHalf(Node head) {
        if (head == null || head.next == null) return null;
        Node slow = head, fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        Node second = slow.next;
        slow.next = null;
        return second;
    }

    static Node create(int... a) {
        Node dummy = new Node(0), tail = dummy;
        for (int x : a) {
            tail.next = new Node(x);
            tail = tail.next;
        }
        return dummy.next;
    }

    static void print(Node head) {
        for (Node p = head; p != null; p = p.next)
            System.out.print(p.data + (p.next == null ? "\n" : " -> "));
        if (head == null) System.out.println("(empty)");
    }

    static void test(Node head) {
        Node second = splitListInHalf(head);
        System.out.print("First half: ");
        print(head);
        System.out.print("Second half: ");
        print(second);
    }

    public static void main(String[] args) {
        test(create(1, 2, 3, 4, 5));
        test(create(1, 2, 3, 4));
    }
}
