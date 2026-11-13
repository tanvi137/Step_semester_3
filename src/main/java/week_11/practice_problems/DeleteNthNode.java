package week_11.practice_problems;

public class DeleteNthNode {
    static class Node {
        int data;
        Node next;
        Node(int data) { this.data = data; }
    }

    static Node deleteNthNode(Node head, int n) {
        if (n == 1) return head.next;
        Node current = head;
        for (int i = 1; i < n - 1; i++) current = current.next;
        current.next = current.next.next;
        return head;
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
        print(deleteNthNode(create(10, 20, 30, 40), 3));
        print(deleteNthNode(create(10, 20, 30, 40), 1));
    }
}
