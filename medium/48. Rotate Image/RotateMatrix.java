//https://leetcode.com/problems/rotate-image/
public class RotateMatrix {
    public void rotate(int[][] matrix) {
        int n = matrix.length - 1;
        for (int i = 0; i < n + 1 / 2; i++) {
            for (int j = i; j < n - i; j++) {
                int prev = matrix[i][j];
                int curr = matrix[j][n - i];
                matrix[j][n - i] = prev;
                prev = curr;
                curr = matrix[n - i][n - j];
                matrix[n - i][n - j] = prev;
                prev = curr;
                curr = matrix[n - j][i];
                matrix[n - j][i] = prev;
                matrix[i][j] = curr;
            }
        }
    }
}
