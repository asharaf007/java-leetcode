package Java.leetcodeSolution.medium;
//Question Link Below
//https://leetcode.com/problems/3sum/
import java.util.*;

public class ThreeSum {
    public static void main(String[] args) {
        int[] nums={-1,0,1,2,-1,-4,2};
        System.out.println(threeSum(nums));
    }
    public static List<List<Integer>> threeSum(int[] nums) {
        int n=nums.length;
        Arrays.sort(nums);
        List<List<Integer>> list=new ArrayList<>();
        for(int i=0;i<n-2;i++){
            if(nums[i]>0) break;
            if(i>0&&nums[i]==nums[i-1]){
                continue;
            }
            int j=i+1;
            int k=n-1;
            //using two pointer approach
            while(j<k){
                if(j>i+1&&nums[j]==nums[j-1]){
                    j++;
                    continue;
                }
                if(k<n-1&&nums[k]==nums[k+1]){
                    k--;
                    continue;
                }
                int sum=nums[i]+nums[j]+nums[k];
                if(sum==0){
                    list.add(Arrays.asList(nums[i],nums[j],nums[k]));
                    k--;j++;
                }
                else if(sum>0){
                    k--;
                }
                else{
                    j++;
                }
            }
        }
        return list;
    }
}
