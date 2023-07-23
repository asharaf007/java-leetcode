package Java.leetcodeSolution.easy;
//https://leetcode.com/problems/power-of-four/
public class PowerOfFour {
    public static void main(String[] args) {
        System.out.println(isPowerOfFour(1));
    }
    public static boolean isPowerOfFour(int n) {
        return ((n&(n-1))==0 && n>0 )&& (n==1||n%10==4 || n%10==6) ? true : false;
    }
}
