package Java.leetcodeSolution.easy;

import Java.OOPS.customDataStructures.tree.TreeNode;

//https://leetcode.com/problems/minimum-absolute-difference-in-bst/
public class MinAbsDiff {
    int min=Integer.MAX_VALUE;
    int prev=min;
    public int getMinimumDifference(TreeNode root) {
        solve(root);
        return min;
    }
    private void solve(TreeNode root){
        if(root==null) return;
        solve(root.left);
        min=Math.min(min,Math.abs(prev-root.val));
        prev=root.val;
        solve(root.right);
    }
}
