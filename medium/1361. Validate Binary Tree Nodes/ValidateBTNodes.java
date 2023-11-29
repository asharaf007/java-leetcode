package Java.leetcodeSolution.medium;
//https://leetcode.com/problems/validate-binary-tree-nodes/
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class ValidateBTNodes {
    public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
        boolean[] parent=new boolean[n];
        for(int i=0;i<leftChild.length;i++){
            if((leftChild[i]!=-1&&parent[leftChild[i]])||(rightChild[i]!=-1&&parent[rightChild[i]])) return false;
            if(leftChild[i]!=-1) parent[leftChild[i]]=true;
            if(rightChild[i]!=-1) parent[rightChild[i]]=true;
        }
        int root=-1;
        for(int i=0;i<parent.length;i++){
            if(!parent[i]&&root!=-1) return false;
            if(!parent[i]) root=i;
        }
        if(root==-1) return false;
        return isBinaryTreeValid(root,leftChild,rightChild);
    }
    private boolean isBinaryTreeValid(int root,int[] leftChild,int[] rightChild){
        Queue<Integer> q=new LinkedList<>();
        boolean [] visited=new boolean[leftChild.length];
        q.offer(root);
        visited[root]=true;
        while(!q.isEmpty()){
            int curr=q.poll();
            if(leftChild[curr]!=-1){
                if(visited[leftChild[curr]]) return false;
                q.offer(leftChild[curr]);
                visited[leftChild[curr]]=true;
            }
            if(rightChild[curr]!=-1){
                if(visited[rightChild[curr]]) return false;
                q.offer(rightChild[curr]);
                visited[rightChild[curr]]=true;
            }
        }
        for(boolean b:visited){
            if(!b) return b;
        }
        return true;
    }
}
