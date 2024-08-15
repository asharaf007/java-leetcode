//https://leetcode.com/problems/substrings-of-size-three-with-distinct-characters/
public class Solution {
    public int countGoodSubstrings(String s) {
        int count=0;
        int n=s.length();
        if(n<3){
            return count;
        }
        int i=2;
        while(i<n){
            if(s.charAt(i)==s.charAt(i-1)){
                i+=2;
            }else if(s.charAt(i-1)==s.charAt(i-2)){
                i++;
            }else if(s.charAt(i)!=s.charAt(i-2)){
                count++;
                i++;
            }else{
                i++;
            }
        }
        return count;
    }
}
