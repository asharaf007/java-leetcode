package Java.leetcodeSolutions.medium;
//Question Link Below
//https://leetcode.com/problems/permutations/

import java.util.*;

public class PermutationsOfArray {
    public static void main(String[] args) {
        int[] nums={1,2,3};

        System.out.println(permute(nums));
    }
    public static List<List<Integer>> permute(int[] nums) {
        List<Integer> up=new ArrayList<>();
        for(int n:nums){
            up.add(n);
        }
        return solve1(new ArrayList<>(), up);
    }
    //work for both positive and negative numbers
    public static List<List<Integer>> solve1(List<Integer> p,List<Integer> up){
        if(up.size()==0){
            List<List<Integer>> ans=new ArrayList<>();
            ans.add(p);
            return ans;
        }
        List<List<Integer>> ans=new ArrayList<>();
        for(int i=0;i<up.size();i++){
            List<Integer> np=new ArrayList<>(p);
            np.add(up.get(i));
            List<Integer> nup=new ArrayList<>();
            for(int j=0;j<i;j++){
                nup.add(up.get(j));
            }
            for(int j=i+1;j<up.size();j++){
                nup.add(up.get(j));
            }
            List<List<Integer>> ll=solve1(np,nup);
            ans.addAll(ll);
        }
        return ans;
    }
    //work for only positive numbers and fails for array containing negative numbers
    public static List<List<Integer>> solve2(String p,String up){
        if(up.length()==0){
            List<List<Integer>> ans=new ArrayList<>();
            List<Integer> list=new ArrayList<>();
            for(int i=0;i<p.length();i++){
                int n=p.charAt(i)-'0';
                list.add(n);
            }
            ans.add(list);
            return ans;
        }
        List<List<Integer>> ans=new ArrayList<>();
        for(int i=0;i<up.length();i++){
            String temp=up.substring(0,i)+up.substring(i+1);
            List<List<Integer>> ll=solve2(p+up.charAt(i),temp);
            ans.addAll(ll);
        }
        return ans;
    }

}
