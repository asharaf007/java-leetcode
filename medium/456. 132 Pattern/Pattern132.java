package Java.leetcodeSolution.medium;

import java.util.*;

//question link
//https://leetcode.com/problems/132-pattern/
public class Pattern132 {
    public static void main(String[] args) {
        int[] nums={3,5,0,3,4};
        System.out.println(find132pattern(nums));
    }
    public static boolean find132pattern(int[] nums) {
        int size=nums.length;
        if(size<3){
            return false;
        }
        Deque<Integer> stack=new ArrayDeque<>();
        int k=-1;
        for(int j=size-1;j>=0;j--){
            if(k>-1&&nums[k]>nums[j]){
                return true;
            }
            while(!stack.isEmpty()&&nums[j]>nums[stack.peek()]){
                k=stack.pop();
            }
            stack.push(j);
        }
        return false;
    }
}
