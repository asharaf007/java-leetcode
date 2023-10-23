package Java.leetcodeSolution.hard;

import java.util.ArrayDeque;
import java.util.Deque;

//question link
//https://leetcode.com/problems/longest-valid-parentheses/
public class LongestValidParenthesis {
    public static void main(String[] args) {
        String s = "()(()(())()))))())()()()()()";
        System.out.println(longestValidParentheses(s));
    }

    public static int longestValidParentheses(String s) {
        int max_length = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(-1); // Initialize the stack with -1 to handle edge cases

        for (int i = 0; i < s.length(); i++) {
            char currentChar = s.charAt(i);
            if (currentChar == '(') {
                stack.push(i);
            } else { // currentChar == ')'
                stack.pop();
                if (stack.isEmpty()) {
                    // This closing parenthesis doesn't have a matching opening parenthesis before it
                    stack.push(i);
                } else {
                    // Calculate the length of the valid parentheses substring
                    int current_length = i - stack.peek();
                    max_length = Math.max(max_length, current_length);
                }
            }
        }

        return max_length;
    }

}
