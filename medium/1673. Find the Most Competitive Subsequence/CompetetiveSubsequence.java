package Java.leetcodeSolution.medium;

import java.util.*;

//question link
//https://leetcode.com/problems/find-the-most-competitive-subsequence/
public class CompetetiveSubsequence {
    public static void main(String[] args) {
        int[] nums={11,52,57,91,47,95,86,46,87,47,70,56,54,61,89,44,3,73,1,7,87,48,17,25,49,54,6,72,97,62,16,11,47,34,68,58,14,36,46,65,2,15};
        System.out.println(Arrays.toString(mostCompetitive(nums,18)));
    }
    public static int[] mostCompetitive(int[] nums, int k) {
        Deque<Integer> stack=new ArrayDeque<>();
        int[] ans=new int[k];
        int size=nums.length;
        for(int i=0;i<size;i++){
            while(size-i+stack.size()>k&&!stack.isEmpty()&&nums[i]<stack.peek()){
                stack.pop();
            }
            if(stack.size()<k)
            stack.push(nums[i]);
        }
        int i=stack.size()-1;
        while(!stack.isEmpty()){
            ans[i--]=stack.pop();
        }
        return ans;
    }
}
