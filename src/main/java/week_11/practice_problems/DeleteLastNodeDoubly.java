package week_11.practice_problems;

public class DeleteLastNodeDoubly {
    static class DNode {
        int data;
        DNode prev, next;
        DNode(int data) { this.data = data; }
    }

    static DNode deleteLastNodeDoubly(DNode head) {
        if (head == null || head.next == null) return null;
        DNode p = head;
        while (p.next != null) p = p.next;
        p.prev.next = null;
        p.prev = null;
        return head;
    }

    static DNode create(int... a) {
        DNode head = null, tail = null;
        for (int x : a) {
            DNode node = new DNode(x);
            if (head == null) head = node;
            else {
                tail.next = node;
                node.prev = tail;
            }
            tail = node;
        }
        return head;
    }

    static void print(DNode head) {
        if (head == null) {
            System.out.println("(empty list)");
            return;
        }
        for (DNode p = head; p != null; p = p.next)
            System.out.print(p.data + (p.next == null ? "\n" : " <-> "));
    }

    public static void main(String[] args) {
        print(deleteLastNodeDoubly(create(1, 2, 3)));
        print(deleteLastNodeDoubly(create(5)));
    }
}
