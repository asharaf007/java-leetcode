package Java.leetcodeSolution.easy;

import Java.OOPS.customDataStructures.tree.TreeNode;

//https://leetcode.com/problems/minimum-depth-of-binary-tree/
public class MinDepthOfBT {
    int min=Integer.MAX_VALUE;
    public int minDepth(TreeNode root) {
        if(root==null) return 0;
        solve(root,1);
        return min;
    }
    private void solve(TreeNode root,int length){
        if(root.left==null&&root.right==null){
            min=Math.min(min,length);
            return;
        }
        if(root.left!=null)solve(root.left,length+1);
        if(root.right!=null)solve(root.right,length+1);
    }
}
