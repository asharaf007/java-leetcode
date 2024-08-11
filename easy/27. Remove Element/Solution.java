//https://leetcode.com/problems/remove-element/
public class Solution {
    public int removeElement(int[] nums, int val) {
        int i=0,j=nums.length-1;
        int count=0;
        while(i<=j){
            if(nums[i]==val){
                count++;
                int temp=nums[i];
                nums[i]=nums[j];
                nums[j]=temp;
                j--;
            }else{
                i++;
            }
        }
        return nums.length-count;
    }
}
