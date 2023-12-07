package Java.leetcodeSolution.hard;
//https://leetcode.com/problems/kth-ancestor-of-a-tree-node/submissions/1113387655/
class TreeAncestor {
    int[][] jump;
    int m;
    public TreeAncestor(int n, int[] parent) {
        m=(int)(Math.log(n) / Math.log(2)) + 1;
        jump=new int[m][n];
        jump[0]=parent;
        for(int i=1;i<m;i++){
            for(int j=0;j<n;j++){
                int pre=jump[i-1][j];
                jump[i][j]=pre==-1?pre:jump[i-1][pre];
            }
        }
    }

    public int getKthAncestor(int node, int k) {
        int i=0;
        while(k>0){
            if((k&1)==1) node=jump[i][node];
            if(node==-1) return -1;
            k=(k>>1);
            i++;
        }
        return node;
    }
}
