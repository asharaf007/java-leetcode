package Java.leetcodeSolution.hard;

import java.util.ArrayDeque;
import java.util.Deque;

//https://leetcode.com/problems/parsing-a-boolean-expression/
public class parsingBooleanString {
    public static void main(String[] args) {
        System.out.println(parseBoolExpr("!(&(f,t))"));
    }

    public static boolean parseBoolExpr(String expression) {
        Deque<Character> stack = new ArrayDeque<>();
        for (char ch : expression.toCharArray()) {
            if (ch == ')') {
                StringBuilder s = new StringBuilder();
                while (!stack.isEmpty() && (stack.peek() == 'f' || stack.peek() == 't')) s.append(stack.pop());
                switch (stack.pop()) {
                    case '&':
                        stack.push(logicalAND(s));
                        break;
                    case '|':
                        stack.push(logicalOR(s));
                        break;
                    case '!':
                        stack.push(s.charAt(0) == 't' ? 'f' : 't');
                        break;
                }
                continue;
            }
            if (ch != '(' && ch != ',') stack.push(ch);
        }
        return stack.pop() == 't';
    }

    private static char logicalOR(StringBuilder s) {
        boolean temp = false;
        for (int i = 0; i < s.length(); i++) {
            temp |= s.charAt(i) == 't' ? true : false;
        }
        return temp ? 't' : 'f';
    }

    private static char logicalAND(StringBuilder s) {
        boolean temp = true;
        for (int i = 0; i < s.length(); i++) {
            temp &= s.charAt(i) == 't' ? true : false;
        }
        return temp ? 't' : 'f';
    }
}
