package Java.leetcodeSolution.medium;
//https://leetcode.com/problems/validate-binary-search-tree/

import Java.OOPS.customDataStructures.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;
public class ValidateBST {
    public static void main(String[] args) {
        TreeNode node = new TreeNode(2);
        node.left = new TreeNode(1);
        node.right = new TreeNode(3);
        System.out.println(new ValidateBST().isValidBST(node));
    }
    public boolean isValidBST(TreeNode root) {
//      return solve(root,new ArrayList<>(),new ArrayList<>());
        return helper(root,Long.MIN_VALUE,Long.MAX_VALUE);
    }
    private boolean helper(TreeNode root,long min,long max){
        if(root==null) return true;
        if((min!=Long.MIN_VALUE&&root.val<=min)||(max!=Long.MAX_VALUE&&root.val>=max)) return false;
        return helper(root.left,min,root.val)&&helper(root.right,root.val,max);
    }
    private boolean solve(TreeNode root, List<TreeNode> n, List<Boolean> isRight){
        if(root==null) return true;
        n.add(root);
        isRight.add(false);
        if(!solve(root.left,n,isRight)) return false;
        isRight.set(isRight.size()-1,true);
        if(!solve(root.right,n,isRight)) return false;
        n.remove(n.size()-1);
        isRight.remove(isRight.size()-1);
        int i=n.size()-1;
        while(i>=0){
            if(isRight.get(i)&&n.get(i).val>=root.val) return false;
            if(!isRight.get(i)&&n.get(i).val<=root.val) return false;
            i--;
        }
        return true;
    }
}
