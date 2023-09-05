package Java.leetcodeSolution.medium;
//Question Link Below
//https://leetcode.com/problems/permutations-ii/
import java.util.*;
public class PermutationsTwo {
    public static void main(String[] args) {
        int[] nums={1,2,1};
        System.out.println(permuteUnique(nums));
    }
    public static List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        List<Integer> up=new ArrayList<>();
        for(int n:nums){
            up.add(n);
        }
        return solve(new ArrayList<>(),up);
    }
    public static List<List<Integer>> solve(List<Integer> p,List<Integer> up){
        if(up.size()==1){
            List<List<Integer>> ans=new ArrayList<>();
            p.add(up.get(0));
            ans.add(p);
            return ans;
        }
        List<List<Integer>> ans=new ArrayList<>();
        int curr=11;
        for(int i=0;i<up.size();i++){
            if(curr!=up.get(i)) {
                curr=up.get(i);
                List<Integer> np = new ArrayList<>(p);
                np.add(curr);
                List<Integer> nup = new ArrayList<>(up);
                nup.remove(i);
                ans.addAll(solve(np,nup));
            }
        }
        return ans;
    }
}
