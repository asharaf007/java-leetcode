package Java.leetcodeSolution.medium;
//https://leetcode.com/problems/powx-n/description/
public class Power {
    public static void main(String[] args) {
        System.out.println(myPow(2,50));
    }
    public static double myPow(double x, int n) {

        if(n==0){
            return 1;
        }
        if(x==0||x==1||n==1){
            return x;
        }
        if(n==-2147483648){

            return myPow(x,n+1)/x;
        }
        if(n<0){
            x=1/x;
            n=-n;
        }
        if(n%2==1){
            return myPow(x*x,n/2)*x;
        }
        return myPow(x*x,n/2);
    }
}
