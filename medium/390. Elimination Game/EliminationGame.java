package Java.leetcodeSolution.medium;
//https://leetcode.com/problems/elimination-game/
public class EliminationGame {
    public int lastRemaining(int n) {
        int level=1,left=1,right=n;
        boolean leftToRight=true;
        while(n>1){
            if(leftToRight){
                left+=level;
                if(n%2==1)right-=level;
            }
            else {
                right-=level;
                if(n%2==1) left+=level;
            }
            level*=2;
            n/=2;
            leftToRight=!leftToRight;
        }
        return left;
    }
}
