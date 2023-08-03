package Java.leetcodeSolution.medium;
//https://leetcode.com/problems/search-a-2d-matrix/
public class SearchInSortedMatrix {
    public static void main(String[] args) {
        int[][] matrix={{3, 30, 38},{36, 43, 60},{40, 51, 69}};
        System.out.println(search(matrix, 45));
    }
    static boolean search(int matrix[][],int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int st = 0;
        int end = (m * n) - 1;
        int mid = st + (end - st) / 2;
        while (st <= end) {
            int midVal = matrix[mid / n][mid % n];
            if (midVal == target) {
                return true;
            }
            if (midVal < target) {
                st = mid + 1;
            } else {
                end = mid - 1;
            }
            mid = st + (end - st) / 2;
        }
        return false;
    }
}
