package week_12.assignment_problems;

public class BrowserTabStrip {
    static class Tab {
        String name;
        Tab prev, next;
        Tab(String name) { this.name = name; }
    }

    Tab head, current;

    void print(String action) {
        System.out.print(action + ": ");
        for (Tab p = head; p != null; p = p.next) {
            if (p != head) System.out.print(" <-> ");
            System.out.print(p == current ? "[" + p.name + "]" : p.name);
        }
        if (head == null) System.out.print("(empty)");
        System.out.println();
    }

    void open(String name) {
        Tab node = new Tab(name);
        if (current == null) head = node;
        else {
            node.prev = current;
            node.next = current.next;
            if (current.next != null) current.next.prev = node;
            current.next = node;
        }
        current = node;
        print("OPEN " + name);
    }

    void close() {
        if (current == null) {
            System.out.println("CLOSE: no tabs");
            return;
        }
        String name = current.name;
        Tab old = current;
        if (old.prev != null) old.prev.next = old.next;
        else head = old.next;
        if (old.next != null) old.next.prev = old.prev;
        current = old.next != null ? old.next : old.prev;
        print("CLOSE " + name);
    }

    void back() {
        if (current == null || current.prev == null) {
            System.out.println("BACK: already at first tab");
            return;
        }
        current = current.prev;
        print("BACK");
    }

    void forward() {
        if (current == null || current.next == null) {
            System.out.println("FORWARD: already at last tab");
            return;
        }
        current = current.next;
        print("FORWARD");
    }

    void printBackward() {
        Tab p = head;
        if (p == null) {
            System.out.println("Backward: (empty)");
            return;
        }
        while (p.next != null) p = p.next;
        System.out.print("Backward: ");
        while (p != null) {
            System.out.print(p.name);
            p = p.prev;
            if (p != null) System.out.print(" <-> ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        BrowserTabStrip browser = new BrowserTabStrip();
        browser.open("Mail");
        browser.open("Docs");
        browser.open("Maps");
        browser.back();
        browser.back();
        browser.back();
        browser.open("Drive");
        browser.close();
        browser.forward();
        browser.close();
        browser.printBackward();
    }
}
// Open, close, back, forward: O(1) for list operations
// Printing the strip: O(n), printBackward: O(n)
