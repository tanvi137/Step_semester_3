package week_12.assignment_problems;

public class LastButKAnnouncement {
    static class Node {
        int data;
        Node next;
        Node(int data) { this.data = data; }
    }

    static String kthFromEnd(Node head, int k) {
        if (k <= 0) return "Invalid k";
        Node lead = head, trail = head;

        for (int i = 0; i < k; i++) {
            if (lead == null) return "Invalid k";
            lead = lead.next;
        }
        while (lead != null) {
            lead = lead.next;
            trail = trail.next;
        }
        return k + " from the end: " + trail.data;
    }

    static Node create(int... values) {
        Node dummy = new Node(0), tail = dummy;
        for (int x : values) {
            tail.next = new Node(x);
            tail = tail.next;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        System.out.println(kthFromEnd(create(301, 302, 303, 304, 305, 306), 2));
        System.out.println(kthFromEnd(create(301, 302, 303), 5));
    }
}
// One traversal: O(n) time, O(1) space
// Two-pass method is also O(n), but traverses the list twice
