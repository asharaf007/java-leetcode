package Java.leetcodeSolution.medium;
//https://leetcode.com/problems/decode-ways/
public class DecodeWays {
    public static void main(String[] args) {
        System.out.println(new DecodeWays().numDecodings("12"));
    }
    public int numDecodings(String s) {
        int[] dp=new int[s.length()];
        for(int i=0;i< s.length();i++) dp[i]=-1;
        return solve(s,0,dp);
    }
    private int solve(String s,int i,int[] dp){
        if(i==s.length()) return 1;
        if(i>s.length()||s.charAt(i)=='0') return 0;
        if(dp[i]>-1) return dp[i];
        dp[i]=solve(s,i+1,dp);
        if(s.charAt(i)=='1'||(s.charAt(i)=='2'&&i+1<s.length()&&s.charAt(i+1)<'7'))
            dp[i]+=solve(s,i+2,dp);
        return dp[i];
    }
}
