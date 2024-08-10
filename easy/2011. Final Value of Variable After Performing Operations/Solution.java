//https://leetcode.com/problems/final-value-of-variable-after-performing-operations/
public class Solution {
    public int finalValueAfterOperations(String[] operations) {
        int res=0;
        for(String s:operations){
            res+=s.charAt(1)=='-'?-1:1;
        }
        return res;
    }
}
