package Java.leetcodeSolution.easy;

//https://leetcode.com/problems/ugly-number/
public class UglyNumber {
    public static void main(String[] args) {
        System.out.println(new UglyNumber().isUgly(789));
    }
    public boolean isUgly(int n) {
        if (n <= 0) return false;
        while (n % 5 == 0) n /= 5;
        while (n % 3 == 0) n /= 3;
        while (n % 2 == 0) n /= 2;
        return n == 1;
    }
}
