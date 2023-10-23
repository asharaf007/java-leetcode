package Java.leetcodeSolution.medium;

//https://leetcode.com/problems/reach-a-number/
public class ReachANumber {
    public static void main(String[] args) {
        System.out.println(reachNumber(89857));
    }

    public static int reachNumber(int target) {
        if (target < 0) target *= -1;
        int pos = 0;
        int moves = 1;
        while (true) {
            if (pos >= target && (pos - target) % 2 == 0) return moves - 1;
            pos += moves++;
        }
    }
}
