package Java.leetcodeSolution.medium;

import java.util.HashMap;

//Question Link Below
//https://leetcode.com/problems/4sum-ii/description/
public class FourSum2 {
    public static void main(String[] args) {
        int[] nums1 = {0, 1, -1};
        int[] nums2 = {-1, 1, 0};
        int[] nums3 = {0, 0, 1};
        int[] nums4 = {-1, 1, 1};
        System.out.println(fourSumCount(nums1, nums2, nums3, nums4));
    }

    public static int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        int n = nums1.length;
        int count = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int sum = nums3[i] + nums4[j];
                map.put(sum, map.getOrDefault(sum, 0) + 1);
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int sum = -(nums1[i] + nums2[j]);
                count += map.getOrDefault(sum, 0);
            }
        }
        return count;
    }
}
