package Java.leetcodeSolution.medium;
//https://leetcode.com/problems/step-by-step-directions-from-a-binary-tree-node-to-another/
import Java.OOPS.customDataStructures.tree.TreeNode;

public class StepByStepPath {
    public String getDirections(TreeNode root, int startValue, int destValue) {
        String s=path(root,startValue).toString();
        String d=path(root,destValue).toString();
        int i=0;
        while(s.length()>i&&d.length()>i&&s.charAt(i)==d.charAt(i))i++;
        s=s.substring(i);
        d=d.substring(i);
        i=s.length();
        s="";
        while(i-->0) s+='U';
        return s+d;
    }
    private StringBuilder path(TreeNode root,int s){
        if(root==null) return null;
        if(root.val==s) return new StringBuilder("");
        StringBuilder left=path(root.left,s);
        StringBuilder right=path(root.right,s);
        if(left==null && right==null) return null;
        if(left!=null) return left.insert(0,'L');
        return right.insert(0,'R');
    }
}
