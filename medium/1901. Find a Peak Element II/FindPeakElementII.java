package Java.leetcodeSolution.medium;

import java.util.Arrays;

//https://leetcode.com/problems/find-a-peak-element-ii/
public class FindPeakElementII {
    public static void main(String[] args) {
        FindPeakElementII obj = new FindPeakElementII();
        System.out.println(Arrays.toString(obj.findPeakGrid(new int[][]{{48, 36, 35, 17, 48}, {38, 28, 38, 26, 24}})));
    }

    public int[] findPeakGrid(int[][] mat) {
        int n = mat.length;
        int l = 0, r = n - 1;
        while (l < r) {
            int mid = (l + r) / 2;
            int[] m = maxElementAndIndex(mat[mid]);
            int[] mp1 = mid + 1 < n ? maxElementAndIndex(mat[mid + 1]) : new int[]{-1, -1};
            if (m[0] > mp1[0]) {
                if (r - l == 1) return new int[]{mid, m[1]};
                r = mid;
            } else {
                if (r - l == 1) return new int[]{mid + 1, mp1[1]};
                l = mid;
            }
        }
        return new int[]{0, maxElementAndIndex(mat[0])[1]};
    }

    private int[] maxElementAndIndex(int[] arr) {
        int ans = 0, index = 0;
        for (int i = 0; i < arr.length; i++)
            if (arr[i] > ans) {
                ans = arr[i];
                index = i;
            }
        return new int[]{ans, index};
    }
}
