package Java.leetcodeSolutions.easy;
//Question Link Below
//https://leetcode.com/problems/plus-one/

import java.util.Arrays;

public class PlusOne {
    public static void main(String[] args) {
        int[] digits={9,9,9,9,9,9,9,9,9};
        System.out.println(Arrays.toString(plusOne(digits)));
    }
    public static int[] plusOne(int[] digits) {
        int i=digits.length-1;
        int carry=1;
        while(carry!=0&&i>=0){
            int value=carry+digits[i];
            digits[i--]=value%10;
            carry=value/10;
        }
        if(carry==1){
            int[] ans=new int[digits.length+1];
            ans[0]=1;
            return ans;
        }
        return digits;
    }
}
