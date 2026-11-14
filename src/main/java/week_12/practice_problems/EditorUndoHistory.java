package week_12.practice_problems;

public class EditorUndoHistory {
    static class Editor {
        String[] history;
        int top = -1;

        Editor(int capacity) {
            history = new String[capacity];
        }

        void type(String word) {
            if (top == history.length - 1) {
                System.out.println("rejected: history full");
                return;
            }
            history[++top] = word;
            print();
        }

        void undo() {
            if (top == -1) {
                System.out.println("rejected: nothing to undo");
                return;
            }
            history[top--] = null;
            print();
        }

        void print() {
            if (top == -1) {
                System.out.println("(empty)");
                return;
            }
            for (int i = 0; i <= top; i++) {
                if (i > 0) System.out.print(" ");
                System.out.print(history[i]);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Editor editor = new Editor(3);
        editor.type("Hi");
        editor.type("there");
        editor.type("all");
        editor.type("now");
        editor.undo();
        editor.undo();
        editor.undo();
        editor.undo();
    }
}
// Stack push/pop: O(1), Display: O(n)
// Each successful command including printing: O(n)
