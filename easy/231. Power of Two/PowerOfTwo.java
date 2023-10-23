package Java.leetcodeSolution.easy;

//https://leetcode.com/problems/power-of-two/
public class PowerOfTwo {
    public static void main(String[] args) {
        System.out.println(isPowerOfTwo(8));
    }

    public static boolean isPowerOfTwo(int n) {
        return (n & (n - 1)) == 0 && n > 0 ? true : false;
    }
}
