package Java.leetcodeSolution.medium;

import java.util.ArrayDeque;
import java.util.Deque;
//https://leetcode.com/problems/evaluate-reverse-polish-notation/
public class EvaluateReversePolish {
    public static void main(String[] args) {
        System.out.println(evalRPN(new String[]{"10","6","9","3","+","-11","*","/","*","17","+","5","+"}));
    }
    public static int evalRPN(String[] tokens) {
        Deque<Integer> stack=new ArrayDeque<>();
        for(int i=0;i<tokens.length;i++){
            if(tokens[i].charAt(0)<48&&tokens[i].length()==1) {
                int a=stack.pop();
                int b=stack.pop();
                switch (tokens[i].charAt(0)){
                    case '+':b+=a;break;
                    case '-':b-=a;break;
                    case '*':b*=a;break;
                    case '/':b/=a;break;
                }
                stack.push(b);
            }
            else{
                stack.push(Integer.parseInt(tokens[i]));
            }
        }
        return stack.pop();
    }
}
