package Java.leetcodeSolution.easy;
//https://leetcode.com/problems/fibonacci-number/
public class FibonacciNumber {
    public static void main(String[] args) {
        System.out.println(fib(6));
    }
    public static int fib(int n) {
        if(n==0||n==1){
            return n;
        }
        int fib=0;
        int prev2=0;
        int prev1=1;
        for(int i=2;i<=n;i++){
            fib=prev1+prev2;
            prev2=prev1;
            prev1=fib;
        }
        return fib;
    }
}
