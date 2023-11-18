package Java.leetcodeSolution.easy;
//https://leetcode.com/problems/maximum-depth-of-binary-tree/
import Java.OOPS.customDataStructures.tree.TreeNode;

public class MaxDepthOfBinaryTree {
    public int maxDepth(TreeNode node) {
        if(node==null) return 0;
        return Math.max(maxDepth(node.left),maxDepth(node.right))+1;
    }
}
