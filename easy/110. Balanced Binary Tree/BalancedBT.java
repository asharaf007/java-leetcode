package Java.leetcodeSolution.easy;

import Java.OOPS.customDataStructures.tree.TreeNode;

//https://leetcode.com/problems/balanced-binary-tree/
public class BalancedBT {
    public boolean isBalanced(TreeNode root) {
        if(root==null) return true;
        if(!isBalanced(root.left)||!isBalanced(root.right)) return false;
        int leftHeight=root.left==null?0:root.left.val;
        int rightHeight=root.right==null?0:root.right.val;
        root.val=Math.max(leftHeight,rightHeight)+1;
        return Math.abs(leftHeight-rightHeight)<2;
    }
}
