package Java.leetcodeSolution.hard;

import Java.OOPS.customDataStructures.tree.TreeNode;

//https://leetcode.com/problems/binary-tree-cameras/
public class BinaryTreeCameras {
    public static void main(String[] args) {
        TreeNode root=new TreeNode(0);
        root.left=new TreeNode(1);
        root.left.right=new TreeNode(2);
        root.left.left=new TreeNode(2);
        System.out.println(new BinaryTreeCameras().minCameraCover(root));
    }
    public int minCameraCover(TreeNode root){
        int[] ans=helper(root);
        if(ans[1]==1) return ans[0];
        return ans[0]+1;
    }
    public int[] helper(TreeNode root) {
        if(root==null) return new int[]{0,1,0};
        if(root.left==null&&root.right==null) return new int[]{0,0,0};
        int[] left=helper(root.left),right=helper(root.right);
        int hasCamera=(left[1]+right[1])==2?0:1;
        int isCovered=(left[2]+right[2]+hasCamera)==0?0:1;
        int cameraCount=left[0]+right[0]+hasCamera;
        return new int[]{cameraCount,isCovered,hasCamera};
    }
}
