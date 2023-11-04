package Java.leetcodeSolution.medium;

//https://leetcode.com/problems/perfect-squares/
public class NumSquares {
    public static void main(String[] args) {
        System.out.println(new NumSquares().numSquares(93));
    }
    public int numSquares(int n) {
        //dp solution
        /*
        int[] dp=new int[n+1];
        return solve(n,dp);
        */
        //Math solution
        int sqrt=(int) Math.sqrt(n);
        if(sqrt*sqrt==n) return 1;
        while((n&3)==0) n/=4;   //n%4==0
        if((n&7)==7) return 4;  //n%8==7
        for(int i=1;i<=sqrt;i++) if(Math.pow((int)Math.sqrt(n-i*i),2)==n-i*i) return 2;
        return 3;
    }
    private int solve(int n,int[] dp){
        if(dp[n]>0) return dp[n];
        int i=(int)Math.sqrt(n),min=10000;
        if(i*i==n) return 1;
        while(i>0) min=Math.min(min,1+solve(n-(i*i--),dp));
        return dp[n]=min;
    }
}
