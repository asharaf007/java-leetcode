package Java.leetcodeSolution.hard;
//Question Link Below
// https://leetcode.com/problems/split-array-largest-sum/
public class SplitArrayLargestSum {

    public static void main(String[] args) {
        int arr[] = { 7,2,5,10,8 };
        System.out.println(splitArray(arr, 3));
    }

    public static int splitArray(int nums[], int k) {
        // step 1 find search space
        int minNum =10000000;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (nums[i] < minNum) {
                minNum = nums[i];
            }
        }
        int st = minNum;// lowest bound
        int end = sum;// highest bound
        int mid = (st + end) / 2;
        while (st <= end) {
            if (findCount(nums, mid)[0] <= k) {
                end = mid-1;
            }
            else if (findCount(nums, mid)[0] > k){
                st = mid+1 ;
            }
            mid = (st + end) / 2;
        }
        return findCount(nums,st)[1];
    }
    

    public static int[] findCount(int[] arr, int target) {
        int ans[] = { 0, 0 };
        int i = 0;
        int count = 0;
        int currSum = 0;
        int maxSum = -1;
        while (i < arr.length) {
            if (currSum+arr[i] <= target) {
                currSum += arr[i];
                i++;
            } 
            else {
                count++;
                currSum =arr[i];
                i++;
            }
            if (maxSum < currSum) {
                maxSum = currSum;
            }
        }
        ans[0] = count + 1;
        ans[1] = maxSum;
        return ans;
    }
}
