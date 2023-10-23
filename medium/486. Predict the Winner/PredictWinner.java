package Java.leetcodeSolution.medium;

//https://leetcode.com/problems/predict-the-winner/
public class PredictWinner {
    public static void main(String[] args) {
        int[] nums = {1, 5, 2};
        System.out.println(PredictTheWinner(nums));
    }

    public static boolean PredictTheWinner(int[] nums) {
        return solve(nums, 0, nums.length - 1, 0, 0, 0);
    }

    private static boolean solve(int[] nums, int st, int end, int player1, int player2, int chance) {
        if (st > end) {
            return player1 >= player2;
        }
        if (st == end) {
            if (chance == 0) return solve(nums, st + 1, end, player1 + nums[st], player2, 1);
            return solve(nums, st + 1, end, player1, player2 + nums[st], 0);
        }
        if (chance == 0) {
            boolean first = solve(nums, st + 1, end, player1 + nums[st], player2, 1);
            boolean second = solve(nums, st, end - 1, player1 + nums[end], player2, 1);
            return first || second;
        }
        boolean first = solve(nums, st + 1, end, player1, player2 + nums[st], 0);
        boolean second = solve(nums, st, end - 1, player1, player2 + nums[end], 0);
        return first && second;
    }
}
