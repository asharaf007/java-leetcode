package Java.leetcodeSolution.medium;

import java.util.Arrays;
import java.util.HashMap;

//https://leetcode.com/problems/find-right-interval/
public class FindRightInterval {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(findRightInterval(new int[][]{{2,3}})));
    }
    public static int[] findRightInterval(int[][] intervals) {
        int[] ans=new int[intervals.length];
        int[] arr=new int[intervals.length];
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<intervals.length;i++){
            map.put(intervals[i][0],i);
            arr[i]=intervals[i][0];
        }
        Arrays.sort(arr);
        for(int i=0;i<intervals.length;i++){
            int target=intervals[i][1];
            int l=0,r=arr.length-1;
            while(l<r){
                int m=l+(r-l)/2;
                if(arr[m]==target) break;
                if(arr[m]>target) r=m;
                else l=m+1;
            }
            if(l>r) ans[i]=-1;
            else {
                int m=l+(r-l)/2;
                ans[i]=arr[m]>=target?map.get(arr[m]):-1;
            }
        }
        return ans;
    }
}
