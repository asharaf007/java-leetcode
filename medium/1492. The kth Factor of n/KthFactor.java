package Java.leetcodeSolution.medium;
//https://leetcode.com/problems/the-kth-factor-of-n/
public class KthFactor {
    public static void main(String[] args) {
        System.out.println(kthFactor(12,3));
    }
    public static int kthFactor(int n, int k) {
        int i=1;
        for(;i*i<n;i++){
            if(n%i==0&&--k==0) return i;
        }
        for(i=sqrt(n);i>=1;i--){
            if(n%i==0&&--k==0) return n/i;
        }
        return -1;
    }
    private static int sqrt(int n){
        int i=1;
        while(i*i<=n)i++;
        return i-1;
    }
}
