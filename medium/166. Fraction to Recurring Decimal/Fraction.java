package Java.leetcodeSolution.medium;
//https://leetcode.com/problems/fraction-to-recurring-decimal/
import java.util.HashMap;

public class Fraction {
    public static void main(String[] args) {
        System.out.println(new Fraction().fractionToDecimal(42356378,134672346));
    }
    public String fractionToDecimal(int numerator, int denominator) {
        boolean isNegative =(numerator<0&&denominator>0)||(numerator>0&&denominator<0);
        long n=Math.abs((long)numerator),d=Math.abs((long)denominator);
        StringBuilder ans=new StringBuilder();
        ans.insert(0,n/d);
        long num=n%d;
        if(num==0) return isNegative?ans.insert(0,'-').toString():ans.toString();
        ans.append('.');
        HashMap<Long,Integer> ht=new HashMap<>();
        while(num!=0&&!ht.containsKey(num)){
            ht.put(num,ans.length());
            ans.append((num*=10)/d);
            num%=d;
        }
        if(ht.containsKey(num)) ans.insert(ht.get(num),"(").append(')');
        return isNegative?ans.insert(0,'-').toString():ans.toString();
    }
}
