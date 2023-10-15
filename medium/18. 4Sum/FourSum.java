package Java.leetcodeSolution.medium;
//https://leetcode.com/problems/4sum/
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {
    public static void main(String[] args) {
        System.out.println(fourSum(new int[]{1,-2,-5,-4,-3,3,3,5},-11));
    }
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        int n=nums.length;
        Arrays.sort(nums);
        List<List<Integer>> list=new ArrayList<>();
        for(int i=0;i<n-3;i++){
            if (nums[i]>=0&&nums[i] > target) break;
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            for(int l=i+1;l<n-2;l++) {
                if (nums[i]+nums[l] >= 0&&nums[i]+nums[l]>target) break;
                if (l > i+1 && nums[l] == nums[l - 1]) {
                    continue;
                }
                int j = l + 1;
                int k = n - 1;
                //using two pointer approach
                while (j < k) {
                    if (j > l + 1 && nums[j] == nums[j - 1]) {
                        j++;
                        continue;
                    }
                    if (k < n - 1 && nums[k] == nums[k + 1]) {
                        k--;
                        continue;
                    }
                    int sum = nums[i] +nums[l]+ nums[j] + nums[k];
                    if (sum == target) {
                        list.add(Arrays.asList(nums[i],nums[l], nums[j], nums[k]));
                        k--;
                        j++;
                    } else if (sum > target) {
                        k--;
                    } else {
                        j++;
                    }
                }
            }
        }
        return list;
    }
}
