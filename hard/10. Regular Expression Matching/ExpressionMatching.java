package Java.leetcodeSolution.hard;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/regular-expression-matching/
public class ExpressionMatching {
    public static void main(String[] args) {
        System.out.println(isMatch("aa","a*"));
    }
    public static boolean isMatch(String s, String p) {
        int[][] dp=new int[s.length()+1][p.length()+1];
        for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp[0].length;j++) dp[i][j]=-1;
        }
        return dfs(s,p,0,0,dp)==1;
    }
    private static int dfs(String s,String p,int i,int j,int[][] dp){
        if(i<=s.length()&&j<=p.length()&&dp[i][j]!=-1) return dp[i][j];
        if(i>=s.length()&&j>=p.length()) return 1;
        if(j>=p.length()) return 0;
        boolean match=i<s.length()&&(s.charAt(i)==p.charAt(j)||p.charAt(j)=='.');
        if(j+1<p.length()&&p.charAt(j+1)=='*'){
            dp[i][j]=dfs(s,p,i,j+2,dp)==1||(match&&dfs(s,p,i+1,j,dp)==1)?1:0;
            return dp[i][j];
        }
        if(match) {
            dp[i][j]=dfs(s,p,i+1,j+1,dp);
            return dp[i][j];
        }
        dp[i][j]=0;
        return dp[i][j];
    }
}
