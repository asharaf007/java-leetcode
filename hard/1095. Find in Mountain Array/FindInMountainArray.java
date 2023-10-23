package Java.leetcodeSolution.hard;

interface MountainArray {
    public default int get(int index) {
        return 1;
    }

    public default int length() {
        return 1;
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
