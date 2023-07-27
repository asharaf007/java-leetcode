package Java.leetcodeSolution.medium;
//https://leetcode.com/problems/find-kth-bit-in-nth-binary-string/
public class KthBit {
    public static void main(String[] args) {
        System.out.println(findKthBit(3,5));
    }
    public static char findKthBit(int n, int k) {
        if(n==1||k==1){
            return '0';
        }
        //return binaryStr(n).charAt(k-1);
        int len=1<<n;
        if(k<len/2){
            return findKthBit(n-1,k);
        }
        if(k==len/2){
            return '1';
        }
        return findKthBit(n-1,len-k)=='0'?'1':'0';
    }

    private static String binaryStr(int n) {
        if(n==1){
            return "0";
        }
        String small=binaryStr(n-1);
        return small+"1"+reverse(invert(small));
    }
    private static String reverse(String s){
        StringBuilder ans=new StringBuilder();
        for(int i=s.length()-1;i>=0;i--){
            ans.append(s.charAt(i));
        }
        return ans.toString();
    }
    private static String invert(String s){
        StringBuilder ans= new StringBuilder();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='0') ans.append('1');
            else ans.append('0');
        }
        return ans.toString();
    }
}
