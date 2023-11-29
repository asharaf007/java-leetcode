package Java.leetcodeSolution.easy;

import Java.OOPS.customDataStructures.tree.TreeNode;

import java.util.Stack;

//https://leetcode.com/problems/sum-of-left-leaves/
public class SumOfLeftLeaves {
    public int sumOfLeftLeaves(TreeNode root) {
        Stack<TreeNode> s=new Stack<>();
        int sum=0;
        s.push(root);
        while(!s.isEmpty()){
            TreeNode curr=s.pop();
            if(curr.left==null){
                if(curr.right!=null) s.push(curr.right);
                continue;
            }
            while(curr.left!=null){
                if(curr.right!=null) s.push(curr.right);
                curr=curr.left;
            }
            if(curr.right==null) sum+=curr.val;
            else s.push(curr.right);
        }
        return sum;
    }
}
