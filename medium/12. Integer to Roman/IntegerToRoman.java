package Java.leetcodeSolution.medium;

import java.util.HashMap;

//https://leetcode.com/problems/integer-to-roman/
public class IntegerToRoman {
    public static void main(String[] args) {
        System.out.println(intToRoman(3999));
    }
    private static final HashMap<Integer,Character> map=new HashMap<>(){
        {put(1,'I');put(5,'V');put(10,'X');put(50,'L');put(100,'C');put(500,'D');put(1000,'M');}
    };
    public static String intToRoman(int num){
        StringBuilder sb=new StringBuilder();
        int factor=1;
        while(num>0){
            int rem=num%10;
            if(rem>0) sb.insert(0,helper(rem*factor));
            factor*=10;
            num/=10;
        }
        return sb.toString();
    }
    private static String helper(int num) {
        if(map.containsKey(num)) return ""+map.get(num);
        int minus,divisor;
        if(num>1000){
            divisor=1000;
            minus=1000;
        }else if(num>500){
            divisor=500;
            minus=100;
        }else if(num>100){
            divisor=100;
            minus=100;
        }else if(num>50){
            divisor=50;
            minus=10;
        }else if(num>10){
            divisor=10;
            minus=10;
        }else if(num>5){
            divisor=5;
            minus=1;
        }else {
            divisor=1;
            minus=1;
        }
        if(num+minus==2*divisor||num+minus==5*divisor)
            return ""+map.get(minus)+map.get(num+minus);
        return map.get(divisor)+helper(num-divisor);
    }
}
