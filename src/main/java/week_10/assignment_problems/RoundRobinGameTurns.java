package week_10.assignment_problems;

public class RoundRobinGameTurns {
    static class Node {
        String name;
        Node next;
        Node(String name) { this.name = name; }
    }

    public static void main(String[] args) {
        String[] players = {"Asha", "Ravi", "Neha"};
        Node head = new Node(players[0]), tail = head;
        for (int i = 1; i < players.length; i++) {
            tail.next = new Node(players[i]);
            tail = tail.next;
        }
        tail.next = head;

        Node current = head;
        for (int i = 0; i < 8; i++) {
            System.out.println("Turn " + (i + 1) + ": " + current.name);
            current = current.next;
        }
    }
}
