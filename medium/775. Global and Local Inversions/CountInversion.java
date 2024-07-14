//https://leetcode.com/problems/global-and-local-inversions/
public class CountInversion {
    static int global;

    public boolean isIdealPermutation(int[] arr) {
        int local = 0;
        global = 0;
        mergeSort(arr, 0, arr.length - 1);
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                local++;
            }
        }
        return global == local;
    }

    private int[] mergeSort(int arr[], int st, int end) {
        // System.out.println(Arrays.toString(arr));
        if (st >= end) {
            return new int[] { arr[st] };
        }
        int mid = st + (end - st) / 2;
        int[] left = mergeSort(arr, st, mid);
        int[] right = mergeSort(arr, mid + 1, end);
        int i = 0, j = 0, k = 0;
        //
        while (i < left.length && j < right.length) {
            if (left[i] > right[j]) {
                global += left.length - i;
                j++;
            } else {
                i++;
            }
        }
        //
        i = 0;
        j = 0;
        int[] res = new int[end - st + 1];
        while (i < left.length || j < right.length) {
            if (j == right.length) {
                res[k++] = left[i++];
            } else if (i == left.length) {
                res[k++] = right[j++];
            } else if (left[i] < right[j]) {
                res[k++] = left[i++];
            } else {
                res[k++] = right[j++];
            }
        }
        return res;
    }
}