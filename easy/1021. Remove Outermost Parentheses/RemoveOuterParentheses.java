package Java.leetcodeSolution.easy;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

//https://leetcode.com/problems/remove-outermost-parentheses/
public class RemoveOuterParentheses {
    public static void main(String[] args) {
        String s="(()())(())";
        System.out.println(removeOuterParentheses(s));
    }
    public static String removeOuterParentheses(String s) {
        Stack<Character> stack=new Stack<>();
        StringBuilder ans=new StringBuilder("");
        int count=0;
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(ch==')'){
                if(count==1){
                    StringBuilder temp=new StringBuilder("");
                    while(stack.size()>1){
                        temp.insert(0,stack.pop());
                    }
                    stack.pop();
                    ans.append(temp);
                }
                else{
                    stack.push(ch);
                }
                count--;
            }
            else{
                stack.push(ch);
                count++;
            }
        }
        return ans.toString();
    }
}
