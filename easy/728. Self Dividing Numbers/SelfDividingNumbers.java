package Java.leetcodeSolution.easy;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/self-dividing-numbers/
public class SelfDividingNumbers {
    public static void main(String[] args) {
        System.out.println(isSelfDivisivle(105));
    }
    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> ans=new ArrayList<>();
        while(left<=right){
            if(isSelfDivisivle(left)) ans.add(left);
            left++;
        }
        return ans;
    }
    private static boolean isSelfDivisivle(int n){
        if(n<=9) return true;
        int num=n;
        while(n>0){
            int rem=n%10;
            if(rem==0||num%rem!=0) return false;
            n/=10;
        }
        return true;
    }
}
