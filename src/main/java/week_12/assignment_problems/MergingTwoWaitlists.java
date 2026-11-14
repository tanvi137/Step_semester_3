package week_12.assignment_problems;

public class MergingTwoWaitlists {
    static class Node {
        int data;
        Node next;
        Node(int data) { this.data = data; }
    }

    static Node merge(Node first, Node second) {
        Node dummy = new Node(0), tail = dummy;
        while (first != null && second != null) {
            if (first.data <= second.data) {
                tail.next = first;
                first = first.next;
            } else {
                tail.next = second;
                second = second.next;
            }
            tail = tail.next;
        }
        tail.next = first != null ? first : second;
        return dummy.next;
    }

    static Node create(int... values) {
        Node dummy = new Node(0), tail = dummy;
        for (int x : values) {
            tail.next = new Node(x);
            tail = tail.next;
        }
        return dummy.next;
    }

    static void print(Node head) {
        for (Node p = head; p != null; p = p.next)
            System.out.print(p.data + " -> ");
        System.out.println("null");
    }

    public static void main(String[] args) {
        print(merge(create(3, 8, 15), create(5, 8, 20, 25)));
        print(merge(null, create(4, 9)));
    }
}
// Time: O(m+n), Extra space: O(1)
