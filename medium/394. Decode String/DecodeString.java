package Java.leetcodeSolutions.medium;

import java.util.Stack;

//https://leetcode.com/problems/decode-string/
public class DecodeString {
    public static void main(String[] args) {
        String s="2[abc]3[cd]ef";
        System.out.println(decodeString(s));
    }
    public static String decodeString(String s) {
        Stack<String> stack=new Stack<>();
        String ans="";
        int i=0;
        while(i<s.length()){
            if(s.charAt(i)=='['){
                stack.push("[");
                i++;
            }
            else if(s.charAt(i)==']'){
                String temp=stack.pop();
                stack.pop();
                int times=Integer.parseInt(stack.pop());
                String st="";
                for(int j=0;j<times;j++){
                    st+=temp;
                }
                if(!stack.isEmpty()&&!stack.peek().equals("[")){
                    st=stack.pop()+st;
                    stack.push(st);
                }
                else{
                    stack.push(st);
                }
                i++;
            }
            else{
                int num=0;
                while(i<s.length()&&Character.isDigit(s.charAt(i))){
                    num=num*10+s.charAt(i++)-'0';
                }
                if(num!=0){
                    stack.push(num+"");
                    continue;
                }
                String temp="";
                while(i<s.length()&&Character.isLetter(s.charAt(i))){
                    temp+=s.charAt(i++);
                }
                if(temp!=""){
                    if(!stack.isEmpty()&&!stack.peek().equals("[")){
                        temp=stack.pop()+temp;
                        stack.push(temp);
                    }
                    else{
                        stack.push(temp);
                    }
                }
            }
        }
        while(!stack.isEmpty()){
            ans=stack.pop()+ans;
        }
        return ans;
    }
}
