package Java.leetcodeSolution.medium;
//Question Link Below
//https://leetcode.com/problems/game-of-life/
import java.util.Arrays;

public class GameOfLife {
    public static void main(String[] args) {
        int[][] board={{0,1,0},{0,0,1},{1,1,1},{0,0,0}};
        gameOfLife(board);
        for (int[] a : board) {
            System.out.println(Arrays.toString(a));
        }
    }
    public static void gameOfLife(int[][] board) {
        int m=board.length;
        int n=board[0].length;
        int[][] ans = new int[m][n];
        int i = 0;
        for (int[] a : board) {
            int j = 0;
            for (int b : a) {
                ans[i][j] = b;
                j++;
            }
            i++;
        }
        for(int r=0;r<m;r++){
            for(int c=0;c<n;c++){
                if(shouldBeLive(ans,r,c)){
                    board[r][c]=1;
                }
                else{
                    board[r][c]=0;
                }
            }
        }
    }
    public static boolean shouldBeLive(int[][] board,int r,int c){
        int count=liveCount(board,r,c);
        if(board[r][c]==1){
            return count == 2 || count == 3;
        }
        return count==3;
    }
    public static int liveCount(int[][] board,int r,int c){
        int count=0;
        int m=board.length;
        int n=board[0].length;
        //right
        if(c<n-1&&board[r][c+1]==1){
            count++;
        }
        //left
        if(c>=1&&board[r][c-1]==1){
            count++;
        }
        //up
        if(r>=1&&board[r-1][c]==1){
            count++;
        }
        //down
        if(r<m-1&&board[r+1][c]==1){
            count++;
        }
        //diagonally up left
        if(r>=1&&c>=1&&board[r-1][c-1]==1){
            count++;
        }
        //diagonally down right
        if(r<m-1&&c<n-1&&board[r+1][c+1]==1){
            count++;
        }
        //diagonally up right
        if(r>=1&&c<n-1&&board[r-1][c+1]==1){
            count++;
        }
        //diagonally down left
        if(r<m-1&&c>=1&&board[r+1][c-1]==1){
            count++;
        }
        return count;
    }

}
