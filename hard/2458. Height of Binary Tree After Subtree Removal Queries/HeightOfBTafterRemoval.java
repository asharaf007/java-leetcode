package Java.leetcodeSolution.hard;

import Java.OOPS.customDataStructures.tree.TreeNode;

import java.util.HashMap;

//https://leetcode.com/problems/height-of-binary-tree-after-subtree-removal-queries/
public class HeightOfBTafterRemoval {

    int[] height;
    int[] ans;
    public int[] treeQueries(TreeNode root, int[] queries) {
        int size=count(root);
        ans=new int[size+1];
        height=new int[size+1];
        setHeight(root);
        preCompute(root,0,1);
        for(int i=0;i<queries.length;i++) queries[i]=ans[queries[i]];
        return queries;
    }
    private int getHeight(TreeNode root){
        if(root==null) return -1;
        return height[root.val];
    }
    private int count(TreeNode root){
        if(root==null)return 0;
        return 1+count(root.left)+count(root.right);
    }
    private int setHeight(TreeNode root){
        if(root==null) return -1;
        return height[root.val]=Math.max(setHeight(root.left),setHeight(root.right))+1;
    }
    private void preCompute(TreeNode root,int h,int level){
        if(root==null) return ;
        ans[root.val]=h;
        preCompute(root.left,Math.max(h,level+getHeight(root.right)),level+1);
        preCompute(root.right,Math.max(h,level+getHeight(root.left)),level+1);
    }
}
