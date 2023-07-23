package Java.leetcodeSolution.easy;

import java.util.Arrays;

//https://leetcode.com/problems/reverse-string/
public class ReverseString {
    public static void main(String[] args) {
        char[] s={'a','s','h','a','r','a','f'};
        reverseString(s);
        System.out.println(Arrays.toString(s));
    }
    public static void reverseString(char[] s){
        int end=s.length-1;
        for(int i=0;i<s.length/2;i++){
            char temp=s[i];
            s[i]=s[end-i];
            s[end-i]=temp;
        }
    }
}
