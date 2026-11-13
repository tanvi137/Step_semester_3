package week_11.practice_problems;

public class ReverseFirstKNodes {
    static class Node {
        int data;
        Node next;
        Node(int data) { this.data = data; }
    }

    static Node reverseFirstKNodes(Node head, int k) {
        Node previous = null, current = head;
        for (int i = 0; i < k; i++) {
            Node next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        head.next = current;
        return previous;
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
    }

    public static void main(String[] args) {
        print(reverseFirstKNodes(create(1, 2, 3, 4, 5), 3));
        print(reverseFirstKNodes(create(1, 2, 3, 4, 5), 5));
    }
}
