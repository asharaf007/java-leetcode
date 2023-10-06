package Java.leetcodeSolution.hard;

import java.math.BigInteger;

//https://leetcode.com/problems/minimum-number-of-operations-to-make-string-sorted/
public class MakeStringSorted {
    public static void main(String[] args) {
        MakeStringSorted obj=new MakeStringSorted();
        System.out.println(obj.makeStringSorted("sbkrafnjfshdsjdklffbxbcmvxhsdnvfsgdtwucbdgsfreufjgogpggfnydbcbdgsjsncnvkfiryendgdgstshfyvnfjfjfdeetcodeleetcodeleetcodeleetcode"));
    }
    final static BigInteger M=BigInteger.valueOf((long)1e9+7);
    public int makeStringSorted(String s) {
        int[] count=new int[26];
        BigInteger ans=BigInteger.ZERO,fact=BigInteger.ONE,div=fact;
        int i=2,n=s.length();
        count[s.charAt(n-1)-'a']=1;
        while(i<=n){
            int index=s.charAt(n-i)-'a';
            count[index]++;
            BigInteger mul=BigInteger.ZERO;
            for(int j=0;j<index;j++) mul=mul.add(BigInteger.valueOf(count[j]));
            fact=fact.multiply(BigInteger.valueOf(i-1)).mod(M);
            div=div.multiply(BigInteger.valueOf(count[index])).mod(M);
            BigInteger temp=fact.multiply(mul).mod(M);
            temp=temp.multiply(div.modInverse(M).mod(M)).mod(M);
            ans=ans.add(temp).mod(M);
            i++;
        }
        return ans.intValue();
    }
}