package Java.leetcodeSolution.easy;
//https://leetcode.com/problems/binary-tree-paths/
import Java.OOPS.customDataStructures.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class BTpaths {
    List<String> paths = new ArrayList<String>();
    public List<String> binaryTreePaths(TreeNode root) {
        solve(root,"");
        return paths;
    }
    private void solve(TreeNode root, String path) {
        if(root==null) return;
        String s="->"+root.val;
        path+=s;
        if(root.left == null&&root.right == null) {
            paths.add(path.substring(2));
            return;
        }
        solve(root.left, path);
        solve(root.right, path);
        path=path.substring(0,path.length()-s.length());
    }
}
