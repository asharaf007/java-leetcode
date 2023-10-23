package Java.leetcodeSolution.hard;

//https://leetcode.com/problems/unique-paths-iii/
public class UniquePaths3 {
    public static void main(String[] args) {
        System.out.println(uniquePathsIII(new int[][]{{1, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 0, 2}}));
    }

    public static int uniquePathsIII(int[][] grid) {
        int ans = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    ans = solve(grid, i, j);
                    grid[i][j] = 1;
                }
            }
        }
        return ans;
    }

    private static int solve(int[][] grid, int row, int col) {
        if (row == -1 || row == grid.length || col == -1 || col == grid[0].length || grid[row][col] == -1) return 0;
        if (grid[row][col] == 2) {
            grid[row][col] = -1;
            int ans = isAllVisited(grid);
            grid[row][col] = 2;
            return ans;
        }
        grid[row][col] = -1;
        int right = solve(grid, row, col + 1);
        int down = solve(grid, row + 1, col);
        int left = solve(grid, row, col - 1);
        int up = solve(grid, row - 1, col);
        grid[row][col] = 0;
        return right + left + up + down;
    }

    private static int isAllVisited(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] != -1) return 0;
            }
        }
        return 1;
    }
}
