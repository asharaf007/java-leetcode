package Java.leetcodeSolution.medium;
//https://leetcode.com/problems/factorial-trailing-zeroes/
public class FactorialTrailingZero {
    public static void main(String[] args) {
        System.out.println(trailingZeroes(6754));
    }

    public static int trailingZeroes(int n) {
        int ans=0;
        while(n>=5){
            n/=5;
            ans+=n;
        }
        return ans;
    }
}
