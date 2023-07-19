package Java.leetcodeSolutions.medium;

import java.util.Stack;

//question link
//https://leetcode.com/problems/minimum-insertions-to-balance-a-parentheses-string/
public class MinInsertionsToBalanceParenthesis {
    public static void main(String[] args) {
        String s=")))))))";
        System.out.println(minInsertions(s));
    }
    public static int minInsertions(String s) {
        Stack<Character> stack=new Stack<>();
        int count=0;
        int cnt=0;
        for(char ch:s.toCharArray()){
            if(stack.isEmpty()&&count==1&&ch=='('){
                cnt+=2;
                count=0;
                stack.push(ch);
            }
            else if(ch=='('){
                if(count==1) {
                    cnt += count;
                    count=0;
                    stack.pop();
                }
                stack.push(ch);
            }
            else if(ch==')'){
                if(count==0){
                    count++;
                }
                else{
                    if(!stack.isEmpty()){
                        stack.pop();
                    }else{
                        cnt++;
                    }
                    count=0;
                }
            }
        }
        return stack.isEmpty()?(cnt+(count==0?0:2)):((stack.size()*2)+cnt-count);
    }
}
