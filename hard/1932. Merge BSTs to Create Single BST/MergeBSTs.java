package Java.leetcodeSolution.hard;
//https://leetcode.com/problems/merge-bsts-to-create-single-bst/
import Java.OOPS.customDataStructures.tree.TreeNode;
import java.util.*;

public class MergeBSTs {
    public TreeNode canMerge(List<TreeNode> trees) {
        Set<Integer> set = new HashSet<Integer>();
        HashMap<Integer,TreeNode> map=new HashMap<Integer,TreeNode>();
        for(TreeNode node : trees) {
            map.put(node.val,node);
            if(node.left!=null) {
                if(set.contains(node.left.val)) return null;
                set.add(node.left.val);
            }
            if(node.right!=null) {
                if(set.contains(node.right.val)) return null;
                set.add(node.right.val);
            }
        }
        TreeNode root=null;
        for(TreeNode tree:trees) {
            if(!set.contains(tree.val)){
                if(root!=null) return null;
                root=tree;
            }
        }
        dfs(root,map,set);
        if(map.size()>1) return null;
        if(!isValidBST(root,0,50001)) return null;
        return root;
    }
    private boolean isValidBST(TreeNode root,int min,int max){
        if(root==null) return true;
        if((min!=0&&root.val<=min)||(max!=50001&&root.val>=max)) return false;
        return isValidBST(root.left,min,root.val)&&isValidBST(root.right,root.val,max);
    }
    private void dfs(TreeNode root,Map<Integer,TreeNode> map,Set<Integer> set){
        if(root==null) return;
        if(root.left!=null&&map.containsKey(root.left.val)) root.left=map.remove(root.left.val);
        if(root.right!=null&&map.containsKey(root.right.val)) root.right=map.remove(root.right.val);
        dfs(root.left,map,set);
        dfs(root.right,map,set);
    }
}
