package Java.leetcodeSolution.hard;
//https://leetcode.com/problems/wildcard-matching/
public class WildCardMatching {
    public static void main(String[] args) {
        System.out.println(new WildCardMatching().isMatch("bbbbbbbabbaabbabbbbaaabbabbabaaabbababbbabbbabaaabaab","b*b*ab**ba*b**b***bba"));
    }
    public boolean isMatch(String s, String p) {
        int[][] dp=new int[s.length()+1][p.length()+1];
        for(int i=0; i<dp.length; i++)
            for(int j=0; j<dp[0].length; j++)
                dp[i][j]=-1;
        return solve(s,p,0,0,dp)==1;
    }
    private int solve(String s,String p,int i,int j,int[][] dp) {
        if (i == s.length() && j == p.length()) return 1;
        if (j == p.length()) return 0;
        if (i < s.length()&& dp[i][j] != -1) return dp[i][j];
        if (p.charAt(j) == '*')
            dp[i][j] = (solve(s, p, i, j + 1, dp) == 1 || (i<s.length()&&solve(s, p, i + 1, j, dp) == 1)) ? 1 : 0;
        else if (i < s.length() && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '?'))
            dp[i][j] = solve(s, p, i + 1, j + 1, dp);
        else dp[i][j] = 0;
        return dp[i][j];
    }
}
