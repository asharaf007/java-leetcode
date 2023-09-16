package Java.leetcodeSolution.easy;
//https://leetcode.com/problems/shuffle-string/
public class ShuffleString {
    public String restoreString(String s, int[] indices) {
        char[] string=new char[s.length()];
        for(int i=0;i<s.length();i++) string[indices[i]]=s.charAt(i);
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<s.length();i++) sb.append(string[i]);
        return sb.toString();
    }
}
