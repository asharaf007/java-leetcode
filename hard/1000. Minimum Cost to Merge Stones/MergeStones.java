package Java.leetcodeSolution.hard;

//https://leetcode.com/problems/minimum-cost-to-merge-stones/
public class MergeStones {
    public static void main(String[] args) {
        int[] stones = {3,  2, 4,1};
        System.out.println(mergeStones(stones, 2));
    }

    public static int mergeStones(int[] stones, int k) {
        return solve(stones, 0, k);
    }

    public static int solve(int[] nums, int cost, int k) {
        if (nums.length == 1) return cost;
        if (nums.length < k) return -1;
        return 1;
    }
}
