package Java.leetcodeSolution.medium;
//https://leetcode.com/problems/count-nodes-equal-to-average-of-subtree/
public class CountNodes {
    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
         this.val = val;
         this.left = left;
         this.right = right;}
    }
    public int averageOfSubtree(TreeNode root) {
        return dfs(root)[0];
    }

    private int[] dfs(TreeNode root) {
        if(root==null) return new int[]{0,0};
        int[] left=dfs(root.left),right=dfs(root.right);
        int total=root.val,den=1+left[1]+right[1],ans=left[0]+right[0];
        if(root.left!=null) total+=root.left.val;
        if(root.right!=null) total+=root.right.val;
        if(total/den==root.val) ans++;
        root.val=total;
        return new int[]{ans,den};
    }
}
