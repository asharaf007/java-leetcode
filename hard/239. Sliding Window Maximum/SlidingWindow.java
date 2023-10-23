package Java.leetcodeSolution.hard;

import java.util.ArrayDeque;
import java.util.Arrays;

//question link
//https://leetcode.com/problems/sliding-window-maximum/
public class SlidingWindow {
    public static void main(String[] args) {
        int[] nums = {-6, -10, -7, -1, -9, 9, -8, -4, 10, -5, 2, 9, 0, -7, 7, 4, -2, -10, 8, 7};
        System.out.println(Arrays.toString(maxSlidingWindow(nums, 7)));
    }

    public static int[] maxSlidingWindow(int[] nums, int k) {
        ArrayDeque<Integer> q = new ArrayDeque<>();
        int[] ans = new int[nums.length - k + 1];
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (!q.isEmpty() && q.peek() <= i - k) {
                q.poll();
            }
            while (!q.isEmpty() && nums[q.peekLast()] <= nums[i]) {
                q.pollLast();
            }
            q.offer(i);
            if (i >= k - 1) {
                ans[j++] = nums[q.peek()];
            }
        }
        return ans;
    }
}
