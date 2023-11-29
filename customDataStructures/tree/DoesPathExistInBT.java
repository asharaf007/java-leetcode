package Java.OOPS.customDataStructures.tree;

public class DoesPathExistInBT {
    public boolean exists(TreeNode root,int[] arr){
        return solve(root,arr,0);
    }
    private boolean solve(TreeNode root,int[] arr,int i){
        if(root==null||i==arr.length||arr[i]!=root.val) return false;
        i++;
        if(root.left==null&&root.right==null) return i==arr.length;
        return solve(root.left,arr,i)||solve(root.right,arr,i);
    }
}
