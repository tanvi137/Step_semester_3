package week_11.practice_problems;

public class CountNodes {
    static class Node {
        int data;
        Node next;
        Node(int data) { this.data = data; }
    }

    static int countNodes(Node head) {
        int count = 0;
        for (Node p = head; p != null; p = p.next) count++;
        return count;
    }

    public static void main(String[] args) {
        Node head = new Node(5);
        head.next = new Node(10);
        head.next.next = new Node(15);
        System.out.println(countNodes(head));
        System.out.println(countNodes(null));
    }
}
