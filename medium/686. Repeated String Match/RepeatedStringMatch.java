package Java.leetcodeSolution.medium;
//https://leetcode.com/problems/repeated-string-match/
public class RepeatedStringMatch {
    public static void main(String[] args) {
        System.out.println(repeatedStringMatch("aaac","aac"));
    }
    public static int repeatedStringMatch(String a, String b) {
        if(a.indexOf(b)!=-1) return 1;
        int count=((b.length()-1)/a.length())+1;
        String s=a;
        for(int i=1;i<count;i++) s+=a;
        if(s.indexOf(b)!=-1) return count;
        if((s+a).indexOf(b)!=-1) return count+1;
        return -1;
    }
}
