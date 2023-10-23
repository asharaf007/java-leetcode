package Java.leetcodeSolution.medium;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/find-all-duplicates-in-an-array/
public class AllDuplicates {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        int[] count = new int[100001];
        for (int i = 0; i < nums.length; i++) {
            if (count[nums[i]] == 1) ans.add(nums[i]);
            else count[nums[i]] = 1;
        }
        return ans;
    }

    //another solution by cycle sorting the input array
    public List<Integer> findDuplicates2(int[] nums) {
        List<Integer> ans = new ArrayList<Integer>();
        int i = 0;
        while (i < nums.length) {
            int correct = nums[i] - 1;
            if (nums[i] != nums[correct]) {
                swap(nums, i, correct);
            } else {
                i++;
            }
        }
        i = 0;
        while (i < nums.length) {
            if (nums[i] != i + 1) {
                ans.add(nums[i]);
            }
            i++;
        }
        return ans;
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
