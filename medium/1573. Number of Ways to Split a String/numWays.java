package Java.leetcodeSolution.medium;
// https://leetcode.com/problems/number-of-ways-to-split-a-string/
public class numWays {
    public static void main(String[] args) {
        System.out.println(numWays("101010101010000000110001110000001000000110001110010101010011000000001000011110011111111"));
    }
    private static final int m = 1_000_000_007;
    public static int numWays(String s) {
        int n=s.length();
        int count=0;
        for(int i=0;i<s.length();i++) if(s.charAt(i)=='1') count++;
        if(count%3!=0) return 0;
        if(count==0) return (int)((n - 2L) * (n - 1L) / 2 % m);
        int i=0,j=n-1;long temp=0;
        while(temp<count/3){
            while(s.charAt(i)!='1')i++;
            while(s.charAt(j)!='1')j--;
            temp++;i++;j--;
        }
        temp=1;
        while(s.charAt(i)=='0'){temp++;i++;}
        long ans=temp;temp=1;
        while(s.charAt(j)=='0'){temp++;j--;}
        ans=(ans*temp)%m;
        return (int) ans;
    }
}
