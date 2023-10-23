package Java.leetcodeSolution.medium;

//https://leetcode.com/problems/perfect-squares/
public class NumSquares {
    public static void main(String[] args) {
        System.out.println(numSquares(12));
    }

    public static int numSquares(int n) {
        if (n == 0) return 0;
        int min = 100000;
        int i = (int) Math.sqrt(n);
        while (i > 0) {
            min = Math.min(min, 1 + numSquares(n - (int) Math.pow(i, 2)));
            i--;
        }
        return min;
    }
}
