package Java.leetcodeSolution.easy;

//https://leetcode.com/problems/sqrtx/
public class SquareRoot {
    public int mySqrt(int x) {
        long st = 0;
        long end = x + 1 / 2;
        long mid = st + (end - st) / 2;
        while (st <= end) {
            long temp = mid * mid;
            if (temp > x) end = mid - 1;
            else if (temp < x) st = mid + 1;
            else return (int) mid;
            mid = st + (end - st) / 2;
        }
        return (int) end;
    }
}
