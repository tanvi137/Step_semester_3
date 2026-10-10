package week_10.assignment_problems;

public class TrainCoachesBothWays {
    static class Node {
        String name;
        Node prev, next;
        Node(String name) { this.name = name; }
    }

    Node head, tail;

    void addLast(String name) {
        Node n = new Node(name);
        if (head == null) head = tail = n;
        else { tail.next = n; n.prev = tail; tail = n; }
    }

    void remove(String name) {
        Node p = head;
        while (p != null && !p.name.equals(name)) p = p.next;
        if (p == null) return;
        if (p.prev == null) head = p.next;
        else p.prev.next = p.next;
        if (p.next == null) tail = p.prev;
        else p.next.prev = p.prev;
    }

    void printForward() {
        for (Node p = head; p != null; p = p.next)
            System.out.print(p.name + (p.next == null ? "" : " <-> "));
        System.out.println();
    }

    void printBackward() {
        for (Node p = tail; p != null; p = p.prev)
            System.out.print(p.name + (p.prev == null ? "" : " <-> "));
        System.out.println();
    }

    public static void main(String[] args) {
        TrainCoachesBothWays train = new TrainCoachesBothWays();
        for (String s : new String[]{"Engine", "A1", "B1", "B2", "Guard"})
            train.addLast(s);
        train.remove("B1");
        System.out.print("Forward: ");
        train.printForward();
        System.out.print("Backward: ");
        train.printBackward();
    }
}
