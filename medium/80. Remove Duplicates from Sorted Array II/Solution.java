//https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/
class Solution {
    public int removeDuplicates(int[] nums) {
        int prev = 0;
        int count = 0;
        int i = 0, j = 0;
        while (j < nums.length) {
            int curr = nums[j];
            if (curr == prev) {
                if (count < 2) {
                    count++;
                    swap(nums,i,j);
                    i++;
                }
            } else {
                swap(nums,i,j);
                prev = curr;
                count = 1;
                i++;
            }
            j++;
        }
        return i;
    }
    void swap(int[] nums,int i,int j){
        if(i==j){
            return;
        }
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }
}