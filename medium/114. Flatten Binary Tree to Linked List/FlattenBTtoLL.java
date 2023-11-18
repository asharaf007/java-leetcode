package Java.leetcodeSolution.medium;

import Java.OOPS.customDataStructures.tree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

//https://leetcode.com/problems/flatten-binary-tree-to-linked-list/
public class FlattenBTtoLL {
    public void flatten(TreeNode root) {
        if(root==null) return;
        Stack<TreeNode> stack=new Stack<>();
        TreeNode curr=root;
        while(true) {
            if(curr.right!=null) stack.push(curr.right);
            if(curr.left!=null) {
                curr.right=curr.left;
                curr.left=null;
            }
            else if(stack.isEmpty()) break;
            else curr.right=stack.pop();
            curr=curr.right;
        }
    }
}
