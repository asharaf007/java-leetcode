package Java.leetcodeSolutions.easy;

import java.util.*;

//question link
//https://leetcode.com/problems/valid-parentheses/
public class ValidParenthesis {
    public static void main(String[] args) {
        String s="{}({}";
        System.out.println(isValid(s));
    }
    public static boolean isValid(String s) {
        Stack<Character> st=new Stack<>();
        HashMap<Character,Character> map=new HashMap<>();
        map.put('{','}');
        map.put('(',')');
        map.put('[',']');
        HashSet<Character> closing=new HashSet<>();
        closing.add('}');
        closing.add(')');
        closing.add(']');
        for(int i=0;i<s.length();i++){
            if(!st.isEmpty()&&s.charAt(i)==map.get(st.peek())){
                st.pop();
                continue;
            }
            if(closing.contains(s.charAt(i))){
                return false;
            }
            st.push(s.charAt(i));
        }
        return st.isEmpty();
    }
}
