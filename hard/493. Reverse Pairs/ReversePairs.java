//https://leetcode.com/problems/reverse-pairs/
public class ReversePairs {
    int ans;

    public int reversePairs(int[] nums) {
        ans = 0;
        mergeSort(nums, 0, nums.length - 1);
        return ans;
    }

    private int[] mergeSort(int[] nums, int st, int end) {
        if (st == end) {
            return new int[] { nums[st] };
        }
        int mid = st + (end - st) / 2;
        int[] left = mergeSort(nums, st, mid);
        int[] right = mergeSort(nums, mid + 1, end);
        int i = 0, j = 0;
        while (i < left.length && j < right.length) {
            long a = left[i], b = right[j];
            if (a > 2 * b) {
                ans += left.length - i;
                j++;
            } else {
                i++;
            }
        }

        int[] sorted = new int[end - st + 1];
        i = 0;
        j = 0;
        int k = 0;
        while (i < left.length || j < right.length) {
            if (i == left.length) {
                sorted[k++] = right[j++];
            } else if (j == right.length) {
                sorted[k++] = left[i++];
            } else if (left[i] < right[j]) {
                sorted[k++] = left[i++];
            } else {
                sorted[k++] = right[j++];
            }
        }
        return sorted;
    }
}
