package Java.leetcodeSolution.easy;
//https://leetcode.com/problems/binary-tree-postorder-traversal/
import Java.OOPS.customDataStructures.tree.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;
public class PostOrderTraversal {
    public static void main(String[] args) {
        TreeNode root=new TreeNode(2);
        root.left=new TreeNode(1);
        root.right=new TreeNode(4);
        root.right.left=new TreeNode(3);
        System.out.println(new PostOrderTraversal().postorderTraversal(root));
    }
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ans=new ArrayList<>();
        if(root==null) return ans;
        Stack<TreeNode> stack=new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode curr=stack.pop();
            ans.add(curr.val);
            if(curr.left!=null) stack.push(curr.left);
            if(curr.right!=null) stack.push(curr.right);
        }
        Collections.reverse(ans);
        return ans;
    }
}
