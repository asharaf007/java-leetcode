package Java.leetcodeSolution.medium;
//https://leetcode.com/problems/count-good-numbers/
public class GoodNumber {
    public static void main(String[] args) {
        System.out.println(countGoodNumbers((long)(Math.pow(10,15))));
    }
    private static final long MODULO=(long)(Math.pow(10,9)+7);
    public static int countGoodNumbers(long n) {
        long power4=power(4,n/2);
        long power5=power(5,(n+1)/2);
        return (int) ((power4*power5)%MODULO);
    }
    private static long power(long x,long y){
        if(y==0||x==1){
            return 1;
        }
        long small=power(x,y/2)%MODULO;
        long big=(small*small)%MODULO;
        return y%2==0?big:(big*x)%MODULO;
    }
}
