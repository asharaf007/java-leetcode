package Java.leetcodeSolution.medium;

import java.util.Arrays;

//https://leetcode.com/problems/minimum-absolute-sum-difference/
public class MinAbsSumDif {
    public static void main(String[] args) {
        System.out.println(minAbsoluteSumDiff(new int[]{1, 10, 4, 4, 2, 7}, new int[]{9, 3, 5, 1, 7, 4}));
    }

    public static int minAbsoluteSumDiff(int[] nums1, int[] nums2) {
        final int M = (int) 1e9 + 7;
        int n = nums1.length;
        int[] copy = new int[n];
        for (int i = 0; i < n; i++) copy[i] = nums1[i];
        Arrays.sort(copy);
        long ans = 0;
        int greater = 0;
        int value = 0;
        for (int i = 0; i < n; i++) {
            int diff = Math.abs(nums1[i] - nums2[i]);
            int left = 0, right = n - 1;
            int min = 0;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (copy[mid] == nums2[i]) break;
                if (copy[mid] > nums2[i]) right = mid - 1;
                else left = mid + 1;
            }
            if (left > right)
                min = Math.min(right >= 0 ? nums2[i] - copy[right] : Integer.MAX_VALUE, left < n ? copy[left] - nums2[i] : Integer.MAX_VALUE);
            if (diff - min > 0 && diff - min > greater) {
                ans += value;
                greater = diff - min;
                value = diff;
            } else ans += diff;
        }
        ans += value - greater;
        return (int) (ans % M);
    }
}
