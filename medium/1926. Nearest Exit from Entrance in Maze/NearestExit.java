package Java.leetcodeSolutions.medium;
//Question Link Below
//https://leetcode.com/problems/nearest-exit-from-entrance-in-maze/
public class NearestExit {
    public static void main(String[] args) {
        char[][] maze={
                {'+','.','+','.','+','.','.'},
                {'+','.','+','.','.','.','.'},
                {'+','.','+','.','.','.','+'},
                {'+','.','+','.','.','+','+'},
                {'+','.','.','+','.','.','+'},
                {'+','.','.','.','+','.','+'},
                {'+','.','.','.','+','.','+'},
                {'+','+','+','.','+','.','+'},
                {'+','.','.','.','+','.','+'},
                {'+','.','+','+','+','.','+'},
                {'+','.','+','.','.','.','+'},
                {'+','.','+','.','.','.','+'},
                {'+','.','.','+','.','.','+'},
                {'+','.','.','.','+','.','+'},
                {'+','.','.','.','.','.','+'},
                {'+','.','.','.','.','.','+'},
                {'+','.','.','.','.','.','+'},
                {'+','+','+','+','+','+','+'}

        };
        System.out.println(nearestExit(maze,new int[]{1,6}));
    }
    public static int nearestExit(char[][] maze, int[] entrance) {
        return solve(maze,entrance[0],entrance[1],0);
    }
    static int solve(char[][] matrix,int r,int c,int count){
        int m=matrix.length;
        int n=matrix[0].length;
        if((r==0||r==m-1||c==0||c==n-1)&&count!=0){
            return count;
        }
        matrix[r][c]='+';
        int ans=10000;
        //right check
        if(c+1<n&&matrix[r][c+1]=='.') {
            int right = solve(matrix, r, c + 1, count + 1);
            ans=Math.min(ans,right);
        }
        //left check
        if(c>=1&&matrix[r][c - 1] == '.') {
            int left = solve(matrix, r, c - 1, count + 1);
            ans=Math.min(ans,left);
        }
        //up check
        if(r>=1&&matrix[r-1][c]=='.') {
            int up = solve(matrix, r-1, c, count + 1);
            ans=Math.min(ans,up);
        }
        //down check
        if(r+1<m&&matrix[r+1][c]=='.') {
            int down = solve(matrix, r+1, c, count + 1);
            ans=Math.min(ans,down);
        }
        matrix[r][c]='.';
        if(ans==10000&&count==0){
            return -1;
        }
        return ans;
    }
}
