package Java.leetcodeSolutions.medium;
//Question Link Below
//https://leetcode.com/problems/spiral-matrix/
import java.util.*;
public class SpiralMatrix {
    public static void main(String[] args) {
        int[][] matrix={{1,2,3,4},{5,6,7,8},{9,10,11,12}};
        System.out.println(spiralOrder(matrix));
    }
    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();
        int row_end = matrix.length;
        int col_end = matrix[0].length;
        int row_start = 0;
        int col_start = 0;
        int count = row_end * col_end;
        int row = 0;
        int col = 0;
        while (count>0) {
            while (col < col_end) {
                ans.add(matrix[row][col]);
                col++;
                count--;
            }
            if(count==0){
                return ans;
            }
            col--;
            row++;
            row_start++;
            while (row < row_end) {
                ans.add(matrix[row][col]);
                row++;
                count--;
            }
            if(count==0){
                return ans;
            }
            row--;
            col--;
            col_end--;
            while (col >= col_start) {
                ans.add(matrix[row][col]);
                col--;
                count--;
            }
            if(count==0){
                return ans;
            }
            col++;
            row--;
            row_end--;
            while (row >=row_start) {
                ans.add(matrix[row][col]);
                row--;
                count--;
            }
            if(count==0){
                return ans;
            }
            row++;
            col++;
            col_start++;
        }
        return ans;
    }
}
