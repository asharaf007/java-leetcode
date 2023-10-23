package Java.leetcodeSolution.easy;
//https://leetcode.com/problems/flipping-an-image/

import java.util.Arrays;

public class FlipAndInvertImage {
    public static void main(String[] args) {
        int[][] image = {{1, 1, 0}, {1, 0, 1}, {0, 0, 0}};
        for (int[] a : image) {
            flip(a);
            invert(a);
            System.out.print(Arrays.toString(a));
        }
    }

    public int[][] flipAndInvert(int[][] image) {
        for (int[] a : image) {
            flip(a);
            invert(a);
        }
        return image;
    }

    public static void flip(int[] arr) {
        int st = 0;
        int end = arr.length - 1;
        while (st < end) {
            swap(arr, st, end);
            st++;
            end--;
        }
    }

    public static void invert(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] ^= 1;
        }
    }

    public static void swap(int[] arr, int st, int end) {
        int temp = arr[st];
        arr[st] = arr[end];
        arr[end] = temp;
    }
}
