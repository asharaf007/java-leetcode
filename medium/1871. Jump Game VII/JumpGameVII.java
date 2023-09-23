package Java.leetcodeSolution.medium;
//https://leetcode.com/problems/jump-game-vii/
public class JumpGameVII {
    public static boolean canReach(String s,int minJump,int maxJump){
        if(s.charAt(s.length()-1)=='1') return false;
        boolean[] dp=new boolean[s.length()];
        dp[0]=true;
        int i=0;
        int left=0;
        int right=0;
        while(i<s.length()){
            if(!dp[i]){i++;continue;}
            left=Math.max(right+1,i+minJump);
            right=Math.min(i+maxJump,s.length()-1);
            for(int j=left;j<=right;j++){
                if(s.charAt(j)=='0') dp[j]=true;
            }
            i++;
        }
        return dp[s.length()-1];
    }
}
