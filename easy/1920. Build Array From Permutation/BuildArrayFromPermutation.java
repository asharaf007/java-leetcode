package Java.leetcodeSolution.easy;
//Question Link Below
//https://leetcode.com/problems/build-array-from-permutation/
import java.util.*;

public class BuildArrayFromPermutation {
    public static void main(String[] args) {
        int [] nums={2,3,1,6,4,5,0};
        System.out.println(Arrays.toString(buildArray(nums)));
    }
    public static int[] buildArray(int[] nums) {
        int[] ans=new int[nums.length];
        for (int i=0;i<nums.length;i++) {
            ans[i]=nums[nums[i]];
        }
        return ans;
    }
}
