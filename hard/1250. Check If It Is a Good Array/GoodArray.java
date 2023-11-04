package Java.leetcodeSolution.hard;
//https://leetcode.com/problems/check-if-it-is-a-good-array/
public class GoodArray {
    public boolean isGoodArray(int[] nums) {
        int hcf=0;
        for(int x:nums) if((hcf=hcf(hcf,x))==1) return true;
        return false;
    }
    private static int hcf(int a, int b) {
        if (a == 0) return b;
        return hcf(b % a, a);
    }
}
