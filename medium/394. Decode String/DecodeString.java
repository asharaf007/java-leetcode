package Java.leetcodeSolution.medium;

import java.util.ArrayDeque;
import java.util.Deque;

//https://leetcode.com/problems/decode-string/
public class DecodeString {
    public static void main(String[] args) {
        String s = "2[abc]3[cd]ef";
        System.out.println(decodeString(s));
    }

    public static String decodeString(String s) {
        Deque<String> stack = new ArrayDeque<>();
        StringBuilder ans = new StringBuilder();
        int i = 0;
        while (i < s.length()) {
            if (s.charAt(i) == '[') {
                stack.push("[");
                i++;
            } else if (s.charAt(i) == ']') {
                String temp = stack.pop();
                stack.pop();
                int times = Integer.parseInt(stack.pop());
                StringBuilder st = new StringBuilder();
                for (int j = 0; j < times; j++) {
                    st.append(temp);
                }
                if (!stack.isEmpty() && !stack.peek().equals("[")) {
                    st.insert(0, stack.pop());
                    stack.push(st.toString());
                } else {
                    stack.push(st.toString());
                }
                i++;
            } else {
                int num = 0;
                while (i < s.length() && Character.isDigit(s.charAt(i))) {
                    num = num * 10 + s.charAt(i++) - '0';
                }
                if (num != 0) {
                    stack.push(num + "");
                    continue;
                }
                StringBuilder temp = new StringBuilder();
                while (i < s.length() && Character.isLetter(s.charAt(i))) {
                    temp.append(s.charAt(i++));
                }
                if (temp.toString() != "") {
                    if (!stack.isEmpty() && !stack.peek().equals("[")) {
                        temp.insert(0, stack.pop());
                        stack.push(temp.toString());
                    } else {
                        stack.push(temp.toString());
                    }
                }
            }
        }
        while (!stack.isEmpty()) {
            ans.insert(0, stack.pop());
        }
        return ans.toString();
    }
}
