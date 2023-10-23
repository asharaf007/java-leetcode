package Java.leetcodeSolution.medium;
//https://leetcode.com/problems/sort-an-array/description/

import java.util.Arrays;

public class MergeSortInPlace {
    public static void main(String[] args) {
        int[] arr = {5, 6, 5, 1, 1};
        mergeSort(arr, 0, arr.length);
        System.out.println(Arrays.toString(arr));
    }

    public int[] sortArray(int[] nums) {
        mergeSort(nums, 0, nums.length);
        return nums;
    }

    public static void mergeSort(int[] arr, int st, int end) {
        if (end - st == 1) {
            return;
        }
        int mid = st + (end - st) / 2;
        mergeSort(arr, st, mid);
        mergeSort(arr, mid, end);
        merge(arr, st, mid, end);
    }

    public static void merge(int[] arr, int st, int mid, int end) {
        int i = st;
        int j = mid;
        int k = 0;
        int[] ans = new int[end - st];
        while (i < mid && j < end) {
            if (arr[i] <= arr[j]) {
                ans[k++] = arr[i++];
            } else {
                ans[k++] = arr[j++];
            }
        }
        while (i < mid) {
            ans[k++] = arr[i++];
        }
        while (j < end) {
            ans[k++] = arr[j++];
        }
        for (int l = 0; l < ans.length; l++) {
            arr[st + l] = ans[l];
        }
    }
}
