package Java.leetcodeSolution.medium;

//https://leetcode.com/problems/maximum-value-at-a-given-index-in-a-bounded-array/
public class MaxValAtGivenIndex {
    public static void main(String[] args) {
        System.out.println(maxValue(3, 2, 18));
    }

    public static int maxValue(int n, int index, int maxSum) {
        int lo = 1, hi = maxSum;
        int mid = lo + (hi - lo) / 2;
        while (lo <= hi) {
            long num1 = mid + index - n;
            if (num1 > 0) num1 = sumTillN(num1);
            long num2 = mid - 1 - index;
            if (num2 > 0) num2 = sumTillN(num2);
            long temp = sumTillN(mid) + sumTillN(mid - 1) - num1 - num2;
            if (temp == maxSum) return mid;
            if (temp > maxSum) hi = mid - 1;
            else lo = mid + 1;
            mid = lo + (hi - lo) / 2;
        }
        return lo - 1;
    }

    private static long sumTillN(long n) {
        return (n * (n + 1)) / 2;
    }
}
