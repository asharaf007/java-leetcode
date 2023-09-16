package Java.leetcodeSolution.medium;
//https://leetcode.com/problems/nth-digit/
public class NthDigit {
    public static void main(String[] args) {
        System.out.println(findNthDigit(1000000000));
    }
    public static int findNthDigit(int n) {
        long digit=1;
        while(digit*pow(digit-1)*9<=n){
            n-=digit*pow(digit-1)*9;
            digit++;
        }
        if(n==0) return (int)((pow(digit-1)-1)%10);
        long ans=pow(digit-1)+(n-1)/digit;
        ans/=pow(digit-((n-1)%digit)-1);
        return (int)(ans%10);
    }
    private static long pow(long n){
        long ans=1;
        while(n-->0) ans*=10;
        return ans;
    }
}
