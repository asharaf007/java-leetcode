package Java.leetcodeSolution.hard;

import java.util.ArrayDeque;
import java.util.Deque;

//https://leetcode.com/problems/basic-calculator/
public class BasicCalculator {
    public static void main(String[] args) {
        System.out.println(calculate("2-1+2"));
    }
    public static int calculate(String s) {
        Deque<String> stack=new ArrayDeque<>();
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(ch==')'){
                String temp="";
                while(stack.peek().charAt(0)!='('){
                    temp=stack.pop()+temp;
                }
                stack.pop();
                stack.push(Integer.toString(simplify(temp)));
            }
            else if(ch!=' '){
                stack.push(ch+"");
            }
        }
        String temp="";
        while(!stack.isEmpty()){
            temp=stack.pop()+temp;
        }
        return simplify(temp);
    }

    private static int simplify(String s) {
        int temp=0;
        int i=0;
        char op='+';
        while(i<s.length()){
            char ch=s.charAt(i);
            if(ch=='+'||ch=='-'){
                if((op=='+'&&ch=='+')||(op=='-'&&ch=='-')){
                    op='+';
                }
                else{
                    op='-';
                }
                i++;
                continue;
            }
            String str="";
            while(i<s.length()&&s.charAt(i)!='+'&&s.charAt(i)!='-'){
                str+=s.charAt(i++);
            }
            temp+=op=='+'?Integer.parseInt(str):-Integer.parseInt(str);
            op='+';
        }
        return temp;
    }
}
