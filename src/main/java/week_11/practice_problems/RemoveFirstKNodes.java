package week_11.practice_problems;

public class RemoveFirstKNodes {
    static class Node {
        int data;
        Node next;
        Node(int data) { this.data = data; }
    }

    static Node removeFirstKNodes(Node head, int k) {
        while (head != null && k-- > 0) head = head.next;
        return head;
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
        if (head == null) System.out.println("(empty list)");
        else {
            for (Node p = head; p != null; p = p.next)
                System.out.print(p.data + (p.next == null ? "\n" : " -> "));
        }
    }

    public static void main(String[] args) {
        print(removeFirstKNodes(create(1, 2, 3, 4, 5), 2));
        print(removeFirstKNodes(create(1, 2), 5));
    }
}
