package Java.leetcodeSolution.easy;
//https://leetcode.com/problems/largest-substring-between-two-equal-characters/
public class MaxSubString {
    public int maxLengthBetweenEqualCharacters(String s) {
        int[] index=new int[130];
        int maxLen=-1;
        for(int i=0;i<s.length();i++){
            if(index[s.charAt(i)]==0) index[s.charAt(i)]=i+1;
            else maxLen=Math.max(maxLen,i-index[s.charAt(i)]);
        }
        return maxLen;
    }
}
