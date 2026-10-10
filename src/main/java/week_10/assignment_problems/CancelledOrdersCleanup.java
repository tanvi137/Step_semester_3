package week_10.assignment_problems;

public class CancelledOrdersCleanup {
    static class Node {
        int data;
        Node next;
        Node(int data) { this.data = data; }
    }

    static Node removeAll(Node head, int code) {
        while (head != null && head.data == code) head = head.next;
        Node p = head;
        while (p != null && p.next != null) {
            if (p.next.data == code) p.next = p.next.next;
            else p = p.next;
        }
        return head;
    }

    static void print(Node p) {
        while (p != null) { System.out.print(p.data + " -> "); p = p.next; }
        System.out.println("null");
    }

    public static void main(String[] args) {
        Node head = new Node(5);
        head.next = new Node(3);
        head.next.next = new Node(5);
        head.next.next.next = new Node(8);
        head.next.next.next.next = new Node(5);
        print(removeAll(head, 5));
    }
}
