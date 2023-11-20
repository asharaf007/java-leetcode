package Java.leetcodeSolution.medium;

import Java.OOPS.customDataStructures.tree.TreeNode;

//https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
public class ConstructBT {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return solve(preorder, inorder,0,0,inorder.length-1);
    }
    private TreeNode solve(int[] preorder, int[] inorder, int st1,int st2,int end2){
        if(st1>=preorder.length||st2>end2) return null;
        TreeNode node=new TreeNode(preorder[st1]);
        if(st2==end2)return node;
        int i;
        for(i=st2;i<=end2&&inorder[i]!=preorder[st1];i++){}
        node.left=solve(preorder,inorder,st1+1,st2,i-1);
        node.right=solve(preorder,inorder,i+st1-st2+1,i+1,end2);
        return node;
    }
}
