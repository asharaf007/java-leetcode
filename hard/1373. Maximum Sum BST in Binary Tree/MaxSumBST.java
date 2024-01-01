package Java.leetcodeSolution.hard;

import Java.OOPS.customDataStructures.tree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

//https://leetcode.com/problems/maximum-sum-bst-in-binary-tree/
public class MaxSumBST {
    public static void main(String[] args) {
        MaxSumBST obj=new MaxSumBST();
        TreeNode root=obj.makeTree(new Integer[]{0,9,-8,6,-6,9,3,-5,1,7,1,0,null,-6,null,-4,1,null,3,2,null,null,null,null,null,null,null,null,null,null,null,4,null,10,8,null,null,null,null,1,13,-1,2,10,16,null,null,null,6,null,12,null,17});
        System.out.println(obj.maxSumBST(root));
    }
    TreeNode makeTree(Integer[] values){
        TreeNode root=new TreeNode(values[0]);
        Queue<TreeNode> q=new LinkedList<>();
        q.offer(root);
        int i=1;
        while(i<values.length){
            TreeNode curr=q.poll();
            if(values[i]==null) curr.left=null;
            else {
                curr.left=new TreeNode(values[i]);
                q.offer(curr.left);
            }
            if(++i==values.length){
                curr.right=null;
                break;
            }
            if(values[i]==null) curr.right=null;
            else {
                curr.right=new TreeNode(values[i]);
                q.offer(curr.right);
            }
            i++;
        }
        while(!q.isEmpty()){
            TreeNode curr=q.poll();
            curr.left=null;
            curr.right=null;
        }
        return root;
    }
    int ans=0;
    public int maxSumBST(TreeNode root) {
        dfs(root);
        return ans;
    }
    private int[] dfs(TreeNode root){
        if(root==null) return new int[]{0,1,Integer.MIN_VALUE,Integer.MAX_VALUE};
        int[] left=dfs(root.left);
        int[] right=dfs(root.right);
        int[] res=new int[4];
        res[0]=root.val+left[0]+right[0];
        if(left[1]==1&&right[1]==1&&root.val>left[2]&&root.val<right[3]){
            ans=Math.max(ans,res[0]);
            res[1]=1;
        }
        res[2]=Math.max(right[2],root.val);
        res[3]=Math.min(left[3],root.val);
        return res;
    }
}
