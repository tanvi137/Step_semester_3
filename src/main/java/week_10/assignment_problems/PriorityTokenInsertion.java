package week_10.assignment_problems;

public class PriorityTokenInsertion {
    static class Node {
        int data;
        Node next;
        Node(int data) { this.data = data; }
    }

    Node head;

    void addFirst(int value) {
        Node n = new Node(value);
        n.next = head;
        head = n;
    }

    void addLast(int value) {
        Node n = new Node(value);
        if (head == null) { head = n; return; }
        Node p = head;
        while (p.next != null) p = p.next;
        p.next = n;
    }

    void insertAt(int index, int value) {
        if (index == 0) { addFirst(value); return; }
        Node p = head;
        for (int i = 0; i < index - 1 && p != null; i++) p = p.next;
        if (p == null) throw new IndexOutOfBoundsException();
        Node n = new Node(value);
        n.next = p.next;
        p.next = n;
    }

    void print() {
        Node p = head;
        while (p != null) { System.out.print(p.data + " -> "); p = p.next; }
        System.out.println("null");
    }

    public static void main(String[] args) {
        PriorityTokenInsertion list = new PriorityTokenInsertion();
        list.addLast(101);
        list.addLast(102);
        list.addLast(103);
        list.addFirst(100);
        list.addLast(104);
        list.insertAt(2, 150);
        list.print();
    }
}
