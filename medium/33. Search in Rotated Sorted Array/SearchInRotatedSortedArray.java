package Java.leetcodeSolution.medium;
//https://leetcode.com/problems/search-in-rotated-sorted-array/
public class SearchInRotatedSortedArray {
	public static void main(String[] args) {
		int arr[]= {3,4,5,6,7,0,1,2};
		int ans=search(arr,0);
		System.out.print(ans);
	}
    public static int search(int[] nums, int target) {
        //step 1 find pivot
        //step 2 apply binary search in first part
        //step 3 apply binary search in second part
        //step 4 return answer
        int st=0;
        int end=nums.length-1;
        int pivot=findPivot(nums);
        int ans=binarySearch(nums,target,st,pivot);
        if(ans==-1){
            ans=binarySearch(nums,target,pivot+1,end);
        }
        return ans;
    }
	public static  int findPivot(int[]nums){
        int st=0;
        int end=nums.length-1;
        int mid=(st+end)/2;
        while(st<end){
            if(nums[mid]>nums[mid+1]){
                return mid;
            }
            if(nums[st]>nums[mid]){
                end=mid-1;
            }
            else{
                st=mid+1;
            }
            mid=(st+end)/2;
        }
        return mid;
    }
    public static int binarySearch(int []nums,int target,int st,int end){
        int mid=(st+end)/2;
        while(st<=end){
            if(nums[mid]==target){
                return mid;
            }
            if(nums[mid]>target){
                end=mid-1;
            }
            else{
                st=mid+1;
            }
            mid=(st+end)/2;
        }
        return -1;
    }

}
