//https://leetcode.com/problems/find-missing-and-repeated-values/
public class MissingAndRepeatedValues {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        long n = grid.length;
        long sum = 0;
        long squareSum = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sum += grid[i][j];
                squareSum += grid[i][j] * grid[i][j];
            }
        }
        n *= n;
        int squareDiffOfMnR = (int) (n * (n + 1) * (2 * n + 1) / 6 - squareSum);
        int diffOfMnR = (int) (n * (n + 1) / 2 - sum);
        int sumOfMnR = squareDiffOfMnR / diffOfMnR;
        int repeated, missing;
        if (diffOfMnR > 0) {
            // missing is greater
            missing = (diffOfMnR + sumOfMnR) / 2;
            repeated = sumOfMnR - missing;
        } else {
            // repeated is greater
            repeated = (-diffOfMnR + sumOfMnR) / 2;
            missing = sumOfMnR - repeated;
        }
        return new int[] { repeated, missing };
    }

}
