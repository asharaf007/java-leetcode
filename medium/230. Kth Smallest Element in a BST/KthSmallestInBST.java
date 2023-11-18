package Java.leetcodeSolution.medium;
//https://leetcode.com/problems/kth-smallest-element-in-a-bst/
import Java.OOPS.customDataStructures.tree.TreeNode;
import java.util.ArrayList;
import java.util.List;

public class KthSmallestInBST {
    int count=0;
    public int kthSmallest(TreeNode root, int k) {
        if(root==null) return -1;
        int left=kthSmallest(root.left,k);
        if(left!=-1) return left;
        if(++count==k) return root.val;
        return kthSmallest(root.right,k);
    }
}
