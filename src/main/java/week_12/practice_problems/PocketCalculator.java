package week_12.practice_problems;

import java.util.ArrayDeque;
import java.util.Deque;

public class PocketCalculator {
    static int precedence(char c) {
        return c == '+' || c == '-' ? 1 : c == '*' || c == '/' ? 2 : 0;
    }

    static String toPostfix(String infix) {
        StringBuilder result = new StringBuilder();
        Deque<Character> stack = new ArrayDeque<>();

        for (char c : infix.toCharArray()) {
            if (Character.isDigit(c)) result.append(c);
            else if (c == '(') stack.push(c);
            else if (c == ')') {
                while (!stack.isEmpty() && stack.peek() != '(')
                    result.append(stack.pop());
                stack.pop();
            } else {
                while (!stack.isEmpty() && stack.peek() != '('
                        && precedence(stack.peek()) >= precedence(c))
                    result.append(stack.pop());
                stack.push(c);
            }
        }
        while (!stack.isEmpty()) result.append(stack.pop());
        return result.toString();
    }

    static int evaluate(String postfix) {
        Deque<Integer> stack = new ArrayDeque<>();
        for (char c : postfix.toCharArray()) {
            if (Character.isDigit(c)) stack.push(c - '0');
            else {
                int b = stack.pop(), a = stack.pop();
                switch (c) {
                    case '+': stack.push(a + b); break;
                    case '-': stack.push(a - b); break;
                    case '*': stack.push(a * b); break;
                    case '/':
                        if (b == 0) throw new ArithmeticException("Division by zero");
                        stack.push(a / b);
                        break;
                    default: throw new IllegalArgumentException("Invalid operator");
                }
            }
        }
        return stack.pop();
    }

    public static void main(String[] args) {
        for (String expression : new String[]{"2+3*4", "(2+3)*4", "8/2-3"}) {
            String postfix = toPostfix(expression);
            System.out.println(postfix + " = " + evaluate(postfix));
        }
    }
}
// Conversion: O(n) time, O(n) space
// Evaluation: O(n) time, O(n) space
