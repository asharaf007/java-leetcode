package Java.leetcodeSolution.easy;

import Java.OOPS.customDataStructures.tree.TreeNode;
import java.util.HashMap;

//https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/
public class SortedArrayToBST {
    TreeNode root;
    HashMap<TreeNode,Integer> height=new HashMap<TreeNode,Integer>();
    public TreeNode sortedArrayToBST(int[] nums) {
        for(int num:nums) root=insert(root,num);
        return root;
    }
    private TreeNode insert(TreeNode node, int val) {
        if (node == null) {
            node = new TreeNode(val);
            height.put(node,0);
            return node;
        }
        if (val < node.val) {
            node.left = insert(node.left, val);
        } else {
            node.right = insert(node.right, val);
        }
        height.put(node, Math.max(getHeight(node.left), getHeight(node.right)) + 1);
        return rotate(node);
    }

    private TreeNode rotate(TreeNode node) {
        if(getHeight(node.left) - getHeight(node.right)>1){
            //left case
            if (getHeight(node.left.left) > getHeight(node.left.right))
                //left left case
                return rightRotate(node);
            if(getHeight(node.left.left) < getHeight(node.left.right)){
                //left right case
                node.left = leftRotate(node.left);
                return rightRotate(node);
            }
        }
        if(getHeight(node.right) - getHeight(node.left) > 1) {
            //right case
            if (getHeight(node.right.right) > getHeight(node.right.left))
                //right right case
                return leftRotate(node);
            if(getHeight(node.right.right) < getHeight(node.right.left)){
                //right left case
                node.right = rightRotate(node.right);
                return leftRotate(node);
            }
        }
        return node;
    }
    private TreeNode rightRotate(TreeNode node) {
        TreeNode c=node.left;
        TreeNode t=c.right;
        c.right=node;
        node.left=t;
        height.put(node, Math.max(getHeight(node.left), getHeight(node.right)) + 1);
        height.put(c, Math.max(getHeight(c.left), getHeight(c.right)) + 1);
        return c;
    }
    private TreeNode leftRotate(TreeNode node) {
        TreeNode c=node.right;
        TreeNode t=c.left;
        c.left=node;
        node.right=t;
        height.put(node, Math.max(getHeight(node.left), getHeight(node.right)) + 1);
        height.put(c, Math.max(getHeight(c.left), getHeight(c.right)) + 1);
        return c;
    }
    private int getHeight(TreeNode node) {
        if (node == null) return -1;
        return height.get(node);
    }
}
