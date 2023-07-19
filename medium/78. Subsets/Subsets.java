package Java.leetcodeSolutions.medium;
//Question Link Below
//https://leetcode.com/problems/subsets/

import java.util.*;
public class Subsets {
    public static void main(String[] args) {

        int[] nums={1,2,3};
        System.out.println(subsets1(nums));//using recursion
        System.out.println(subsets2(nums));//without recursion
    }
    public static List<List<Integer>> subsets1(int[] nums) {
        return solve(new ArrayList<>(),0,nums);
    }
    //recursive method
    public static List<List<Integer>> solve(List<Integer> p,int index,int[] nums){
        if(index==nums.length) {
            List<List<Integer>> ans = new ArrayList<>();
            ans.add(p);
            return ans;
        }
        List<List<Integer>> left=solve(p,index+1,nums);
        List<Integer> np=new ArrayList<>(p);
        np.add(nums[index]);
        List<List<Integer>> right=solve(np,index+1,nums);
        left.addAll(right);
        return left;
    }
    //iterative method
    public static List<List<Integer>> subsets2(int[] nums) {
        List<List<Integer>> ans=new ArrayList<>();
        List<Integer> list=new ArrayList<>();
        ans.add(list);
        for(int i=0;i<nums.length;i++){
            int size=ans.size();
            for(int j=0;j<size;j++){
                List<Integer> temp=new ArrayList<>(ans.get(j));
                temp.add(nums[i]);
                ans.add(temp);
            }
        }
        return ans;
    }
}
