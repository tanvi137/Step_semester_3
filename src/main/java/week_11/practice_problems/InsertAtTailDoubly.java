package week_11.practice_problems;

public class InsertAtTailDoubly {
    static class DNode {
        int data;
        DNode prev, next;
        DNode(int data) { this.data = data; }
    }

    static DNode insertAtTailDoubly(DNode head, int value) {
        DNode node = new DNode(value);
        if (head == null) return node;
        DNode current = head;
        while (current.next != null) current = current.next;
        current.next = node;
        node.prev = current;
        return head;
    }

    static void print(DNode head) {
        for (DNode p = head; p != null; p = p.next) {
            if (p != head) System.out.print(" <-> ");
            System.out.print(p.data);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        DNode head = null;
        for (int x : new int[]{1, 2, 3, 4})
            head = insertAtTailDoubly(head, x);
        print(head);
        print(insertAtTailDoubly(null, 7));
    }
}
