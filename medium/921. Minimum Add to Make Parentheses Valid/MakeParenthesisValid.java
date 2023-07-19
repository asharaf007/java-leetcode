package Java.leetcodeSolutions.medium;

import java.util.Stack;

//question link
//https://leetcode.com/problems/minimum-add-to-make-parentheses-valid/
public class MakeParenthesisValid {
    public static void main(String[] args) {
        String s=")(()((";
        System.out.println(minAddToMakeValid(s));
    }
    public static int minAddToMakeValid(String s) {
        Stack<Character> stack=new Stack<>();
        int count=0;
        for(char c:s.toCharArray()){
            if(!stack.isEmpty()&&c==')'&&stack.peek()=='('){
                stack.pop();
            }
            else{
                stack.push(c);
            }
        }
        return stack.size();
    }
}
