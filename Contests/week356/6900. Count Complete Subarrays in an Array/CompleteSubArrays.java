package Java.leetcodeSolution.Contests.week356;

import java.util.HashMap;
import java.util.HashSet;

//https://leetcode.com/contest/weekly-contest-356/problems/count-complete-subarrays-in-an-array/
public class CompleteSubArrays {
    public int countCompleteSubarrays(int[] nums) {
        HashSet<Integer> set=new HashSet<>();
        for(int num:nums){
            set.add(num);
        }
        int unique=set.size();
        int count,j,ans=0;
        for(int i=0;i<=nums.length-unique;i++){
            count=0;
            set.clear();
            for(j=i;j<nums.length;j++){
                if(count==unique){
                    ans+=nums.length-j+1;
                    break;
                }
                if(!set.contains(nums[j])){
                    count++;
                    set.add(nums[j]);
                }
            }
            if(j==nums.length&&count==unique){
                ans+=1;
            }
        }
        return ans;
    }
}
