package Java.leetcodeSolution.medium;
//https://leetcode.com/problems/find-the-duplicate-number/
public class DuplicateNumber {
    public int findDuplicate(int[] nums) {
        int[] count=new int[100001];
        for(int i=0;i<nums.length;i++){
            if(count[nums[i]]==1) return nums[i];
            else count[nums[i]]=1;
        }
        return -1;
    }
}
