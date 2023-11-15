package Java.leetcodeSolution.easy;
//https://leetcode.com/problems/average-of-levels-in-binary-tree/
import Java.OOPS.customDataStructures.tree.TreeNode;
import java.util.*;

public class AverageOfLevels {
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> ans=new ArrayList<>();
        if(root==null) return ans;
        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);
        int currlevelSize=q.size(),count=0;
        double sum=0;
        while(!q.isEmpty()) {
            TreeNode node=q.poll();
            sum+=node.val;
            if(node.left!=null) q.offer(node.left);
            if(node.right!=null) q.offer(node.right);
            if(++count==currlevelSize) {
                ans.add(sum/count);
                sum=0;count=0;
                currlevelSize=q.size();
            }
        }
        return ans;
    }
}
