package Java.leetcodeSolution.medium;
//https://leetcode.com/problems/basic-calculator-ii/
public class BasicCalculatorII {
    public static void main(String[] args) {
        System.out.println(calculate(" 3/2 "));
    }
    public static int calculate(String s) {
        return solve(s,0,'+',0,0);
    }
    private static int solve(String s,int val,char op,int prev,int i){
        if(i==s.length()) return val;
        int num=0;
        while(i<s.length()&&(s.charAt(i)==' '||s.charAt(i)>47&&s.charAt(i)<58))
            if(s.charAt(i++)!=' ') num = num * 10 - 48 + s.charAt(i-1);
        char curOp=i==s.length()?' ':s.charAt(i++);
        if(op=='*') return solve(s,val-prev+prev*num,curOp,prev*num,i);
        else if(op=='/') return solve(s,val-prev+prev/num,curOp,prev/num,i);
        else if(op=='+') return solve(s,val+num,curOp,num,i);
        else return solve(s,val-num,curOp,-num,i);
    }
}
