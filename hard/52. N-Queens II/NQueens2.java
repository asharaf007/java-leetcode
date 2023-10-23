package Java.leetcodeSolution.hard;

//https://leetcode.com/problems/n-queens-ii/
public class NQueens2 {
    public static void main(String[] args) {
        System.out.println(totalNQueens(9));
    }

    private static boolean[][] visited;

    public static int totalNQueens(int n) {
        visited = new boolean[n][n];
        return solve(0);
    }

    private static int solve(int row) {
        if (row == visited.length) {
            return 1;
        }
        int count = 0;
        for (int col = 0; col < visited.length; col++) {
            if (isSafe(row, col)) {
                visited[row][col] = true;
                count += solve(row + 1);
                visited[row][col] = false;
            }
        }
        return count;
    }

    private static boolean isSafe(int r, int c) {
        int i = r - 1;
        int j = c - 1;
        while (i >= 0 && j >= 0) {
            if (visited[i][j]) {
                return false;
            }
            i--;
            j--;
        }
        i = r - 1;
        j = c;
        while (i >= 0) {
            if (visited[i][j]) {
                return false;
            }
            i--;
        }
        i = r - 1;
        j = c + 1;
        while (i >= 0 && j < visited.length) {
            if (visited[i][j]) {
                return false;
            }
            i--;
            j++;
        }
        return true;
    }
}
