package Java.leetcodeSolution.medium;
//https://leetcode.com/problems/path-sum-ii/
import Java.OOPS.customDataStructures.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class PathSumII {
    List<List<Integer>> ans=new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        solve(root,targetSum,new ArrayList<>());
        return ans;
    }
    private void solve(TreeNode root, int targetSum, List<Integer> list){
        if(root==null) return;
        list.add(root.val);
        targetSum-=root.val;
        if(root.left==null&&root.right==null) {
            if (targetSum == 0) ans.add(new ArrayList<Integer>(list));
        }
        else {
            solve(root.left, targetSum, list);
            solve(root.right, targetSum, list);
        }
        list.remove(list.size()-1);
    }
}
