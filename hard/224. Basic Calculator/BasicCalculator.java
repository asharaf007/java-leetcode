package Java.leetcodeSolution.hard;

import java.util.ArrayDeque;
import java.util.Deque;
//https://leetcode.com/problems/basic-calculator/
public class BasicCalculator {
    public static void main(String[] args) {
        System.out.println(calculate("(1+(4+5+2)-3)+(6+8)"));
    }
    public static int calculate(String s) {
        Deque<Integer> stack=new ArrayDeque<>();
        int number=0;
        int ans=0;
        int sign=1;
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            if(Character.isDigit(c)) number=number*10+c-'0';
            else if(c=='+'){
                ans+=sign*number;
                sign=1;
                number=0;
            }
            else if(c=='-'){
                ans+=sign*number;
                sign=-1;
                number=0;
            }
            else if(c=='('){
                stack.push(ans);
                stack.push(sign);
                ans=0;
                sign=1;
            }
            else if(c==')'){
                ans+=sign*number;
                ans*=stack.pop();
                ans+=stack.pop();
                number=0;
            }
        }
        return ans+sign*number;
    }
}
