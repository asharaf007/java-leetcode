package Java.leetcodeSolution.medium;
//https://leetcode.com/problems/path-sum-iii/
import Java.OOPS.customDataStructures.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class PathSumIII {
    public int pathSum(TreeNode root, int targetSum) {
        return solve(root,targetSum,new ArrayList<>());
    }
    private int solve(TreeNode root, int target, List<Integer> list){
        if(root==null) return 0;
        list.add(root.val);
        long sum=0;
        int count=0;
        for(int i=list.size();--i>=0;){
            sum+=list.get(i);
            if(sum==target) count++;
        }
        count+=solve(root.left,target,list)+solve(root.right,target,list);
        list.remove(list.size()-1);
        return count;
    }
}
//return as a list of list
class EveryPathSum {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(3);
        root.right = new TreeNode(2);
        root.right.right = new TreeNode(3);
        root.right.left = new TreeNode(1);
        root.right.right.left = new TreeNode(2);
        root.right.right.left.right = new TreeNode(2);
        System.out.println(new EveryPathSum().everyPath(root, 4));
    }
    List<List<Integer>> paths = new ArrayList<>();
    public List<List<Integer>> everyPath(TreeNode root,int target){
        solve(root,target,new ArrayList<>());
        return paths;
    }
    private void solve(TreeNode root,int target,List<Integer> list){
        if(root==null) return;
        list.add(root.val);
        int sum=0;
        for(int i=list.size();--i>=0;){
            sum+=list.get(i);
            if(sum==target) paths.add(new ArrayList<>(list.subList(i,list.size())));
        }
        solve(root.left,target,list);
        solve(root.right,target,list);
        list.remove(list.size()-1);
    }
}
