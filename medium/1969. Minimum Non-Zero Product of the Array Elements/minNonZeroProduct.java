package Java.leetcodeSolution.medium;
//https://leetcode.com/problems/minimum-non-zero-product-of-the-array-elements/description/
public class minNonZeroProduct {
    public static void main(String[] args) {
        System.out.println(minNonZeroProduct(60));
    }
    private static final long MODULO=(long)(Math.pow(10,9)+7);
    public static int minNonZeroProduct(int p) {
        long max=(1L<<p)-1;
        long x=max-1;
        long y=max/2;
        long ans=power(x,y);
        return (int)(((max%MODULO)*ans)%MODULO);
    }
    private static long power(long x,long y){
        if(y==0) return 1;
        if(y==1) return x%MODULO;
        long small=power(x,y/2);
        long big=(small*small)%MODULO;
        return y%2==0?big:(big*(x%MODULO))%MODULO;
    }
}