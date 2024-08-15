//https://leetcode.com/problems/maximum-length-substring-with-two-occurrences/
public class Solution {
    public int maximumLengthSubstring(String s) {
        int[] occurence=new int[26];
        int max=0;
        int i=0,j=0;
        while(j<s.length()){
            char ch=s.charAt(j);
            if(occurence[ch-'a']==2){
                max=Math.max(max,j-i);
                while(s.charAt(i)!=ch){
                    occurence[s.charAt(i++)-'a']--;
                }
                i++;
            }
            else{
                occurence[ch-'a']++;
            }
            j++;
        }
        return max=Math.max(max,j-i);
    }
}
