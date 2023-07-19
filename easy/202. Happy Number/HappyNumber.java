package Java.leetcodeSolutions.easy;
//Question Link Below
//https://leetcode.com/problems/happy-number/
public class HappyNumber {
    public static void main(String[] args) {
        HappyNumber h=new HappyNumber();
        System.out.println(h.isHappy(4));
    }
    public boolean isHappy(int n) {
        int slow=n;
        int fast=n;
        do{
            slow=squareOfDigits(slow);
            fast=squareOfDigits(squareOfDigits(fast));
            if(fast==1){
                return true;
            }
        }while(fast!=slow);
        return false;
    }
    public int squareOfDigits (int n){
        int ans=0;
        while(n>0){
            int rem=n%10;
            ans+=rem*rem;
            n/=10;
        }
        return ans;
    }
}
