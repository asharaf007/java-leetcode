package Java.leetcodeSolution.hard;

import java.util.Scanner;

interface MountainArray {
    int length=10000;
    int[] arr=new int[length];
    private void populate(Scanner in){
        for(int i=0;i<length;i++) arr[i]=in.nextInt();
    }
    public default int get(int index) {
        return arr[index];
    }

    public default int length() {
        return length;
    }
}

public class FindInMountainArray {
    public int findInMountainArray(int target, MountainArray mountainArr) {
        if (mountainArr.get(0) == target) return 0;
        int l = 1, peakIndex = mountainArr.length() - 1;
        //find in increasing part
        while (l <= peakIndex) {
            int m = l + (peakIndex - l) / 2;
            if (mountainArr.get(m) > mountainArr.get(m - 1)) {
                int st = l, end = m;
                while (st <= end) {
                    int mid = st + (end - st) / 2;
                    int mVal = mountainArr.get(mid);
                    if (mVal == target) return mid;
                    if (mVal < target) st = mid + 1;
                    else end = mid - 1;
                }
                l = m + 1;
            }
            //update peakIndex
            else peakIndex = m - 1;
        }
        //if not found in increasing part then search in the decreasing part
        int st = peakIndex + 1, end = mountainArr.length() - 1;
        while (st <= end) {
            int mid = st + (end - st) / 2;
            int mVal = mountainArr.get(mid);
            if (mVal == target) return mid;
            if (mVal > target) st = mid + 1;
            else end = mid - 1;
        }
        //if not found in both part just return -1
        return -1;
    }
}
