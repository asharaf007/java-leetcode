package Java.leetcodeSolution.hard;
//https://leetcode.com/problems/permutation-sequence/
public class PermutationSequence {
    public static void main(String[] args) {
        PermutationSequence object=new PermutationSequence();
        for(int i=1;i<=6;i++)
        System.out.println(object.getPermutation(3,i));
    }
    private static int[] choices;
    public String getPermutation(int n, int k) {
        choices=new int[n+1];
        return solve(n,k);
    }
    private String solve(int n,int k){
        if(k==0){
            return getString(n);
        }
        int fact=factorial(n-1);
        int divisor=k/fact;
        char ch=getChar(((k-1)/fact)+1);
        return ch+solve(n-1,k-(fact*divisor));
    }

    private int factorial(int i) {
        if(i==0){
            return 1;
        }
        return i*factorial(i-1);
    }

    private char getChar(int count) {
        int i=1;
        while(count>0){
            if(choices[i++]==0) count--;
        }
        choices[i-1]=1;
        return (char) ('0'+i-1);
    }
    private String getString(int n) {
        StringBuilder ans=new StringBuilder();
        int i=choices.length-1;
        while(n>0){
            if(choices[i]==0) {
                ans.append(i);
                n--;
            }
            i--;
        }
        return ans.toString();
    }


}
