package Java.leetcodeSolution.medium;
//https://leetcode.com/problems/minimum-length-of-string-after-deleting-similar-ends/
public class MinLengthAfterDltSimilarEnds {
    public static void main(String[] args) {
        System.out.println(minimumLength("dcceeeecd"));
    }
    public static int minimumLength(String s) {
        int i=0,j=s.length()-1;
        while(i<j){
            if(s.charAt(i)!=s.charAt(j)) return j-i+1;
            char c=s.charAt(i);i++;j--;
            while(i<=j&&s.charAt(i)==c) i++;
            while(i<=j&&s.charAt(j)==c) j--;
        }
        return j-i+1;
    }
}
