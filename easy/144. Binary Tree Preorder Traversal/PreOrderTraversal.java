package Java.leetcodeSolution.easy;
//https://leetcode.com/problems/binary-tree-preorder-traversal/
import Java.OOPS.customDataStructures.tree.TreeNode;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
public class PreOrderTraversal {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ans=new ArrayList<>();
        if(root==null) return ans;
        Stack<TreeNode> stack=new Stack<>();
        TreeNode curr=root;
        while(true){
            ans.add(curr.val);
            if(curr.right!=null) stack.push(curr.right);
            curr=curr.left;
            if(curr==null){
                if(stack.isEmpty()) break;
                curr=stack.pop();
            }
        }
        // Collections.reverse(ans);
        return ans;
    }
}
