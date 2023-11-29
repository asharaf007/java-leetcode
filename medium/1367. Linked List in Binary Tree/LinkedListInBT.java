package Java.leetcodeSolution.medium;

import Java.OOPS.customDataStructures.linkedList.ListNode;
import Java.OOPS.customDataStructures.tree.TreeNode;
//https://leetcode.com/problems/linked-list-in-binary-tree/
public class LinkedListInBT {
    public boolean isSubPath(ListNode head, TreeNode root) {
        if(root==null) return false;
        return solve(root,head)||isSubPath(head,root.left)||isSubPath(head,root.right);
    }
    private boolean solve(TreeNode root, ListNode head){
        if(head==null) return true;
        if(root==null||root.val!= head.val) return false;
        return solve(root.left,head.next)||solve(root.right,head.next);
    }
}
