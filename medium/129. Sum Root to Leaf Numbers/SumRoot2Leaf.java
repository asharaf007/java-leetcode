package Java.leetcodeSolution.medium;

import Java.OOPS.customDataStructures.tree.TreeNode;
//https://leetcode.com/problems/sum-root-to-leaf-numbers/
public class SumRoot2Leaf {
    int sum=0;
    public int sumNumbers(TreeNode root) {
        solve(root,0);
        return sum;
    }
    private void solve(TreeNode root,int curr){
        if(root==null) return;
        curr=curr*10+root.val;
        if(root.left==null&&root.right==null){
            sum+=curr;
            return;
        }
        solve(root.left,curr);
        solve(root.right,curr);
    }
}
