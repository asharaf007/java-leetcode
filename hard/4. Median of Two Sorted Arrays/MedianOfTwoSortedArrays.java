package Java.leetcodeSolution.hard;

//https://leetcode.com/problems/median-of-two-sorted-arrays/
public class MedianOfTwoSortedArrays {
    public static void main(String[] args) {
        System.out.println(new MedianOfTwoSortedArrays().findMedianSortedArrays(new int[]{1}, new int[]{2}));
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int i = 0, j = 0, k = 0, n = nums1.length, m = nums2.length;
        while (k < (n + m - 1) / 2 && i < n && j < m) {
            if (nums1[i] < nums2[j]) i++;
            else j++;
            k++;
        }
        while (k < (n + m - 1) / 2 && i < n) {
            i++;
            k++;
        }
        while (k < (n + m - 1) / 2 && j < m) {
            j++;
            k++;
        }
        int result;
        if ((i < n ? nums1[i] : 10000000) < (j < m ? nums2[j] : 10000000)) result = nums1[i++];
        else result = nums2[j++];
        if ((n + m) % 2 == 1) return result;
        return (result + Math.min(i < n ? nums1[i] : 10000000, j < m ? nums2[j] : 10000000)) / 2.0;
    }
}
