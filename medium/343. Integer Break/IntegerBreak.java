package Java.leetcodeSolution.medium;
//https://leetcode.com/problems/integer-break/
public class IntegerBreak {
    public static void main(String[] args) {
        System.out.println(integerBreak(58));
    }
    public static int integerBreak(int n) {
        if(n<=3) return n-1;
        return (int)(Math.pow(3,(n/3)-1)*(n%3==2?6:3+(n%3)));
    }
}
