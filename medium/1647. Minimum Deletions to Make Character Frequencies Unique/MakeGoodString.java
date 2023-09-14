package Java.leetcodeSolution.medium;

import java.util.Arrays;

//https://leetcode.com/problems/minimum-deletions-to-make-character-frequencies-unique/
public class MakeGoodString {
    public static void main(String[] args) {
        System.out.println(minDeletions("rgkrgkwigavshjgeuigfksyrivvndgfjgoufngmfhdgtdjdoidyrmrfhsfteotyuada"));
    }
    public static int minDeletions(String s) {
        int count=0;
        int[] alpha=new int[26];
        int i;
        for(i=0;i<s.length();i++) alpha[s.charAt(i)-'a']++;
        Arrays.sort(alpha);
        for(i=24;i>=0&&alpha[i]>0;i--){
            if(alpha[i+1]==1){
                while(i>=0&&alpha[i]>0)count+=alpha[i--];
                return count;
            }
            if(alpha[i]>=alpha[i+1]) {count+=alpha[i]-alpha[i+1]+1;alpha[i]=alpha[i+1]-1;}
        }
        return count;
    }
}
