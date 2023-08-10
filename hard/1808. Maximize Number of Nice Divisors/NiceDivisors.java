package Java.leetcodeSolution.hard;

class NiceDivisors {
    public static void main(String[] args) {
        System.out.println(maxNiceDivisors(88));
    }
    private static final int MODULO=1000000007;
    public static  int maxNiceDivisors(int n) {
        if(n<=3){
            return n;
        }
        int rem=n%3;
        n/=3;
        if(rem==1){
            return (int)(((power(3,n-1)%MODULO)*4)%MODULO);
        }
        if(rem==0){
            return (int)(power(3,n)%MODULO);
        }
        return (int)(((power(3,n)%MODULO)*2)%MODULO);
    }
    private static long power(long x,long y){
        if(y==0||x==1){
            return 1;
        }
        long small=power(x,y/2);
        long big=(small*small)%MODULO;
        return y%2==0?big:(big*x)%MODULO;
    }
}
