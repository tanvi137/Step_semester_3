package week_12.assignment_problems;

public class CounsellingListFirst {
    static class Node {
        int data;
        Node next;
        Node(int data) { this.data = data; }
    }

    static Node partition(Node head, int passMark) {
        Node lowDummy = new Node(0), highDummy = new Node(0);
        Node low = lowDummy, high = highDummy;

        while (head != null) {
            Node next = head.next;
            head.next = null;
            if (head.data < passMark) {
                low.next = head;
                low = head;
            } else {
                high.next = head;
                high = head;
            }
            head = next;
        }

        low.next = highDummy.next;
        return lowDummy.next;
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
        print(partition(create(55, 32, 78, 20, 40, 35), 40));
        print(partition(create(60, 70), 40));
    }
}
// Time: O(n), Extra space: O(1), Stable partition
