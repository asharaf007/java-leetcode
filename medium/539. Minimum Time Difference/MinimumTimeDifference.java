package Java.leetcodeSolution.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//https://leetcode.com/problems/minimum-time-difference/
public class MinimumTimeDifference {
    public static void main(String[] args) {
        System.out.println(minutes("00:01"));
    }
    public static int findMinDifference(List<String> timePoints) {
        int[] time=new int[timePoints.size()];
        for(int i=0;i<time.length;i++) time[i]=minutes(timePoints.get(i));
        Arrays.sort(time);
        int min=Integer.MAX_VALUE;
        for(int i=0;i<time.length-1;i++) min=Math.min(min,time[i+1]-time[i]);
        int diff=time[time.length-1]-time[0];
        if(diff>720) diff=1440-diff;
        return Math.min(min,diff);
    }
    private static int minutes(String s){
        return Integer.parseInt(s.substring(0,2))*60+Integer.parseInt(s.substring(3));
    }
}
