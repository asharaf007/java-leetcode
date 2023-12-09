package Java.leetcodeSolution.medium;
//https://leetcode.com/problems/validate-binary-search-tree/

import Java.OOPS.customDataStructures.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;
public class ValidateBST {
    public static void main(String[] args) {
        TreeNode node = new TreeNode(2);
        node.left = new TreeNode(1);
        node.right = new TreeNode(3);
        System.out.println(new ValidateBST().isValidBST(node));
    }
    public boolean isValidBST(TreeNode root) {
        return helper(root,Long.MIN_VALUE,Long.MAX_VALUE);
    }
    private boolean helper(TreeNode root,long min,long max){
        if(root==null) return true;
        if((min!=Long.MIN_VALUE&&root.val<=min)||(max!=Long.MAX_VALUE&&root.val>=max)) return false;
        return helper(root.left,min,root.val)&&helper(root.right,root.val,max);
    }
}
