package Java.leetcodeSolution.easy;
//https://leetcode.com/problems/valid-palindrome-ii/
public class ValidPalindrome2 {
    public static void main(String[] args) {
        System.out.println(validPalindrome("aguokepatgbnvfqmgmlcupuufxoohdfpgjdmysgvhmvffcnqxjjxqncffvmhvgsymdjgpfdhooxfuupuculmgmqfvnbgtapekouga"));
    }
    public static boolean validPalindrome(String s) {
        boolean deleted=false,chance=false;
        int i=0,j=s.length()-1,ii=0,jj=0;
        while(i<=j){
            if(s.charAt(i)!=s.charAt(j)){
                if(deleted){
                    if(chance) return false;
                    chance=true;
                    i=ii;j=jj;
                }
                else{
                    deleted=true;
                    ii=i+1;jj=j;
                    j--;
                }
            }
            else{i++;j--;}
        }
        return true;
    }
}
