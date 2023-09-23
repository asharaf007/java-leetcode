package Java.leetcodeSolution.medium;
//https://leetcode.com/problems/split-two-strings-to-make-palindrome/
public class SplitStringsToMakePalindrome {
    public static void main(String[] args) {
        System.out.println(checkPalindromeFormation("aejbaalflrmkswrydwdkdwdyrwskmrlfqizjezd","uvebspqckawkhbrtlqwblfwzfptanhiglaabjea"));
    }
    public static boolean checkPalindromeFormation(String a, String b) {
        return solve(a,b)||solve(b,a);
    }
    private static boolean solve(String a,String b){
        int l=0,r=a.length()-1;
        while(l<r&&a.charAt(l)==b.charAt(r)){l++;r--;}
        return isPalindrome(a,l,r)||isPalindrome(b,l,r);
    }
    private static boolean isPalindrome(String s,int l,int r){
        while(l<r&&s.charAt(l)==s.charAt(r)){l++;r--;}
        return l>=r;
    }
}
