package Java.leetcodeSolution.medium;
//https://leetcode.com/problems/search-in-rotated-sorted-array/
public class SearchInRotatedSortedArray {
	public static void main(String[] args) {
		int arr[]= {3,1};
		int ans=search(arr,1);
		System.out.print(ans);
	}
    public static int search(int[] nums, int target) {
        int st=0;
        int end=nums.length-1;
        while(st<=end){
            int mid=st+(end-st)/2;
            if(nums[mid]==target) return mid;
            if(nums[st]<=nums[mid]){
                if(nums[st]<=target&&target<nums[mid]) end=mid-1;
                else st=mid+1;
            }
            else{
                if(nums[mid]<target&&nums[end]>=target) st=mid+1;
                else end=mid-1;
            }
        }
        return -1;
    }

}
