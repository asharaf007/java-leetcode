package Java.leetcodeSolution.medium;

import Java.OOPS.customDataStructures.tree.TreeNode;

//https://leetcode.com/problems/longest-univalue-path/
public class LongestUniValuePath {
    private int max=1;
    public int longestUnivaluePath(TreeNode root) {
        if(root==null) return 0;
        solve(root,1001);
        return max-1;
    }
    private int solve(TreeNode root,int target){
        if(root==null) return 0;
        int left=solve(root.left,root.val);
        int right=solve(root.right,root.val);
        max=Math.max(max,left+right+1);
        if(root.val==target) return Math.max(left,right)+1;
        return 0;
    }
}
