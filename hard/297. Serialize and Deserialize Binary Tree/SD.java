package Java.leetcodeSolution.hard;

import Java.OOPS.customDataStructures.tree.TreeNode;

//https://leetcode.com/problems/serialize-and-deserialize-binary-tree/
public class SD {
    int i=0;
    public String serialize(TreeNode root) {
        StringBuilder s=new StringBuilder();
        serialize(root,s);
        return s.toString();
    }
    private void serialize(TreeNode root,StringBuilder s){
        if(root==null){
            s.append("n,");
            return;
        }
        s.append(Integer.toString(root.val)+",");
        serialize(root.left,s);
        serialize(root.right,s);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] parts=data.split(",");
        return deserialize(parts);
    }
    private TreeNode deserialize(String[] parts) {
        if(i>=parts.length||parts[i].charAt(0)=='n') {
            i++;
            return null;
        }
        TreeNode node=new TreeNode(Integer.parseInt(parts[i++]));
        node.left=deserialize(parts);
        node.right=deserialize(parts);
        return node;
    }
}
