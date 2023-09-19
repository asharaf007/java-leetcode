package Java.leetcodeSolution.easy;
//https://leetcode.com/problems/valid-parentheses/
import java.util.*;
public class ValidParenthesis {
    public static void main(String[] args) {
        String s="{}({}";
        System.out.println(isValid(s));
    }
    public static boolean isValid(String s) {
        Deque<Character> stack=new ArrayDeque<>();
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(ch=='}'||ch==')'||ch==']'){
                if(stack.isEmpty()) return false;
                if(ch=='}') if(stack.pop()!='{') return false;
                if(ch==']') if(stack.pop()!='[') return false;
                if(ch==')') if(stack.pop()!='(') return false;
            }
            else stack.push(ch);
        }
        return stack.isEmpty();
    }
}
