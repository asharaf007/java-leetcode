//https://leetcode.com/contest/weekly-contest-405/problems/count-submatrices-with-equal-frequency-of-x-and-y/
public class SubMatrices {
    public int numberOfSubmatrices(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] prefixX = new int[n + 1][m + 1];
        int[][] prefixY = new int[n + 1][m + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                prefixX[i][j] = prefixX[i - 1][j] + prefixX[i][j - 1] - prefixX[i - 1][j - 1];
                prefixY[i][j] = prefixY[i - 1][j] + prefixY[i][j - 1] - prefixY[i - 1][j - 1];
                if (grid[i - 1][j - 1] == 'X') {
                    prefixX[i][j]++;
                } else if (grid[i - 1][j - 1] == 'Y') {
                    prefixY[i][j]++;
                }
            }
        }
        int count = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                int numX = prefixX[i][j];
                int numY = prefixY[i][j];
                if (numX == numY && numX > 0) {
                    count++;
                }
            }
        }
        return count;
    }
}
