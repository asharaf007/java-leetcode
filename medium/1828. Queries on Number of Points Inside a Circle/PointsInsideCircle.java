package Java.leetcodeSolution.medium;

//https://leetcode.com/problems/queries-on-number-of-points-inside-a-circle/
public class PointsInsideCircle {
    public int[] countPoints(int[][] points, int[][] queries) {
        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int count = 0, x1 = queries[i][0], y1 = queries[i][1], r = queries[i][2];
            for (int j = 0; j < points.length; j++) {
                int x2 = points[j][0], y2 = points[j][1];
                if ((x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2) <= r * r) count++;
            }
            ans[i] = count;
        }
        return ans;
    }
}
