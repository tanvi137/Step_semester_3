package week_11.practice_problems;

public class InsertAtEndCircular {
    static class Node {
        int data;
        Node next;
        Node(int data) { this.data = data; }
    }

    static Node insertAtEndCircular(Node head, int value) {
        Node node = new Node(value);
        if (head == null) {
            node.next = node;
            return node;
        }
        Node tail = head;
        while (tail.next != head) tail = tail.next;
        tail.next = node;
        node.next = head;
        return head;
    }

    static void print(Node head) {
        if (head == null) return;
        Node p = head;
        do {
            System.out.print(p.data + " -> ");
            p = p.next;
        } while (p != head);
        System.out.println("(back to " + head.data + ")");
    }

    public static void main(String[] args) {
        Node head = null;
        for (int x : new int[]{1, 2, 3, 4})
            head = insertAtEndCircular(head, x);
        print(head);
        print(insertAtEndCircular(null, 9));
    }
}
