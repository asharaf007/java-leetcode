package Java.leetcodeSolution.medium;
//Question Link Below
//https://leetcode.com/problems/spiral-matrix-ii/
import java.util.Arrays;

public class SpiralMatrixTwo {
    public static void main(String[] args) {
        int[][] ans=generateMatrix(1);
        for(int[] arr:ans)
        System.out.println(Arrays.toString(arr));
    }
    public static int[][] generateMatrix(int n) {
        int[][] ans=new int[n][n];
        int row_end = n;
        int col_end = n;
        int row_start = 0;
        int col_start = 0;
        int count = 1;
        int row = 0;
        int col = 0;
        while (count>0) {
            while (col < col_end) {
                ans[row][col]=count;
                col++;
                count++;
            }
            if(count>n*n){
                return ans;
            }
            col--;
            row++;
            row_start++;
            while (row < row_end) {
                ans[row][col]=count;
                row++;
                count++;
            }
            if(count>n*n){
                return ans;
            }
            row--;
            col--;
            col_end--;
            while (col >= col_start) {
                ans[row][col]=count;
                col--;
                count++;
            }
            if(count>n*n){
                return ans;
            }
            col++;
            row--;
            row_end--;
            while (row >=row_start) {
                ans[row][col]=count;
                row--;
                count++;
            }
            if(count>n*n){
                return ans;
            }
            row++;
            col++;
            col_start++;
        }
        return ans;
    }
}
