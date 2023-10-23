package Java.leetcodeSolution.medium;

//https://leetcode.com/problems/find-peak-element/
public class PeakElement {
    public int findPeakElement(int[] arr) {
        int st = 0;
        int end = arr.length - 1;
        int mid = (st + end) / 2;
        while (st < end) {
            if (arr[mid + 1] < arr[mid]) {
                end = mid;
            } else {
                st = mid + 1;
                ;
            }
            mid = (st + end) / 2;
        }
        return st;
    }
}
