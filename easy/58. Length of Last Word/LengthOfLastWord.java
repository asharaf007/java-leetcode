package Java.leetcodeSolution.easy;
//https://leetcode.com/problems/length-of-last-word/
public class LengthOfLastWord {
    public int lengthOfLastWord(String s) {
        int count=0,i=s.length()-1;
        while(i>=0&&s.charAt(i)==' ')i--;
        while(i-->=0&&s.charAt(i+1)!=' ')count++;
        return count;
    }
}
