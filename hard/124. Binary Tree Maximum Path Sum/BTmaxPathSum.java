package Java.leetcodeSolution.hard;
//https://leetcode.com/problems/binary-tree-maximum-path-sum/
import Java.OOPS.customDataStructures.tree.TreeNode;

public class BTmaxPathSum {
    int max=Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root){
        solve(root);
        return max;
    }
    public int solve(TreeNode root) {
        if(root==null) return 0;
        int left=solve(root.left);
        int right=solve(root.right);
        int lpr=left+right;
        int most=Math.max(0,Math.max(left,right));
        max=Math.max(max,root.val+Math.max(lpr,most));
        return root.val+most;
    }
}
