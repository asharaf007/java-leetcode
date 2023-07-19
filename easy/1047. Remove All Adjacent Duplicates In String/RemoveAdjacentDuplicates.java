package Java.leetcodeSolutions.easy;
//question link
//https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string/
import java.util.Stack;

public class RemoveAdjacentDuplicates {
    public static void main(String[] args) {
        String s="abbaca";
        System.out.println(removeDuplicates(s));
    }
    public static String removeDuplicates(String s) {
        Stack<Character> stack=new Stack<>();
        String ans="";
        for(char ch:s.toCharArray()){
            if(!stack.isEmpty()&&stack.peek()==ch){
                stack.pop();
            }
            else{
                stack.push(ch);
            }
        }
        while(!stack.isEmpty()){
            ans=stack.pop()+ans;
        }
        return ans;
    }
}
