package Java.leetcodeSolutions.medium;

import java.util.ArrayList;
import java.util.Arrays;
//question link
//https://leetcode.com/problems/merge-intervals/
public class MergeIntervals {
    public static void main(String[] args) {
        int[][] intervals={{2,3},{4,5},{6,7},{8,9},{1,10}};
        for (int[] a :
                merge(intervals)) {
            System.out.println(Arrays.toString(a));
        }
    }
    public static int[][] merge(int[][] intervals) {
        Arrays.sort(intervals,(arr1,arr2)->Integer.compare(arr1[0],arr2[0]));
        ArrayList<int[]> arr=new ArrayList<>();
        arr.add(intervals[0]);
        int prev=0;
        for(int i=1;i< intervals.length;i++){
            if(intervals[i][0]<=arr.get(prev)[1]){
                arr.get(prev)[1]=Math.max(arr.get(prev)[1],intervals[i][1]);
            }
            if(intervals[i][0]>arr.get(prev)[1]){
                arr.add(intervals[i]);
                prev++;
            }
        }
        int[][] ans=new int[arr.size()][2];int j=0;
        for(int[] a:arr)
        {
            ans[j++]=a;
        }
        return ans;
    }

}
