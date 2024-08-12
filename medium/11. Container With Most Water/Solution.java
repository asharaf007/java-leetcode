//https://leetcode.com/problems/container-with-most-water/
public class Solution {
    public int maxArea(int[] height) {
        int i=0,j=height.length-1;
        int max=0;
        while(i<j){
            int curr=j-i;
            if(height[i]<height[j]){
                curr*=height[i];
                i++;
            }else{
                curr*=height[j];
                j--;
            }
            max=Math.max(max,curr);
        }
        return max;
    }
}
