package Java.leetcodeSolution.easy;

import Java.OOPS.customDataStructures.tree.TreeNode;

//https://leetcode.com/problems/diameter-of-binary-tree/
public class DiameterOfBinaryTree {
    private int ans;
    public int diameterOfBinaryTree(TreeNode root) {
        height(root);
        return ans;
    }
    private int height(TreeNode node) {
        if(node==null) return 0;
        int leftHeight=height(node.left);
        int rightHeight=height(node.right);
        ans=Math.max(ans,leftHeight+rightHeight);
        return Math.max(leftHeight,rightHeight)+1;
    }
}
