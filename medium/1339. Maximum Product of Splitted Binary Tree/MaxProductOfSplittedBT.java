package Java.leetcodeSolution.medium;

import Java.OOPS.customDataStructures.tree.TreeNode;

//https://leetcode.com/problems/maximum-product-of-splitted-binary-tree/
public class MaxProductOfSplittedBT {
    long max=0;
    int total=0;
    public int maxProduct(TreeNode root) {
        setVal(root);
        total=root.val;
        dfs(root);
        return (int)(max%(long)(1e9+7));
    }
    private void setVal(TreeNode root) {
        if(root.left!=null){
            setVal(root.left);
            root.val+=root.left.val;
        }
        if(root.right!=null){
            setVal(root.right);
            root.val+=root.right.val;
        }
    }
    private void dfs(TreeNode root){
        if(root.left!=null){
            long left=(long)root.left.val*(long)(total-root.left.val);
            if(left>max) max=left;
            dfs(root.left);
        }
        if(root.right!=null){
            long right=(long)root.right.val*(long)(total-root.right.val);
            if(right>max) max=right;
            dfs(root.right);
        }
    }
}
