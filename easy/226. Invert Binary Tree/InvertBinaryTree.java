package Java.leetcodeSolution.easy;
//https://leetcode.com/problems/invert-binary-tree/
import Java.OOPS.customDataStructures.tree.TreeNode;

public class InvertBinaryTree {
    public TreeNode invertTree(TreeNode root) {
        if(root==null) return root;
        TreeNode left=root.left;
        root.left=invertTree(root.right);
        root.right=invertTree(left);
        return root;
    }
}
