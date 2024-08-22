//https://leetcode.com/problems/maximum-length-of-pair-chain/
public class Solution {
    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs,(a,b)->a[1]-b[1]);
        int count=0;
        int prev=-1001;
        for(int i=0;i<pairs.length;i++){
            if(pairs[i][0]>prev){
                count++;
                prev=pairs[i][1];
            }
        }
        return count;
    }
}
