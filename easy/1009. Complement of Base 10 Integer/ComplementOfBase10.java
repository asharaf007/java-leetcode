package Java.leetcodeSolution.easy;
//https://leetcode.com/problems/complement-of-base-10-integer/
public class ComplementOfBase10 {
    public int bitwiseComplement(int n) {
        if(n==0) return 1;
        int adder=1;
        int ans=0;
        while(n>0){
            if((n&1)==0) ans+=adder;
            n>>=1;
            adder<<=1;
        }
        return ans;
    }
}
