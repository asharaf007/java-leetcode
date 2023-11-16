package Java.leetcodeSolution.medium;

public class LongestPalindromicSubstring {
    public static void main(String[] args) {
        System.out.println(new LongestPalindromicSubstring().longestPalindrome("ac"));
    }
    public String longestPalindrome(String s) {
        String[][] dp=new String[s.length()][s.length()];
        return solve(s,0,s.length()-1,dp);
    }
    private String solve(String s,int i,int j,String[][] dp){
            if(i>j) return "";
            if(dp[i][j]!=null) return dp[i][j];
            if(i==j||(s.charAt(i)==s.charAt(j)&&solve(s,i+1,j-1,dp).equals(s.substring(i+1,j)))) return s.substring(i,j+1);
            String first=solve(s,i,j-1,dp);
            String second=solve(s,i+1,j,dp);
            if(first.length()>second.length()) return dp[i][j]=first;
            return dp[i][j]=second;
    }
}
