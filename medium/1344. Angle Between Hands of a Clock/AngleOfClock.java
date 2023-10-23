package Java.leetcodeSolution.medium;

//https://leetcode.com/problems/angle-between-hands-of-a-clock/
public class AngleOfClock {
    public static void main(String[] args) {
        System.out.println(angleClock(9, 43));
    }

    public static double angleClock(int hour, int minutes) {
        double ans = (11.0 / 12.0) * minutes - hour * 5.0;
        if (ans < 0) ans *= -1.0;
        return (ans > 30.0 ? 60.0 - ans : ans) * 6.0;
    }
}
