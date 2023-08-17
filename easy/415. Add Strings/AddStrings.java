package Java.leetcodeSolution.easy;
//https://leetcode.com/problems/add-strings/
public class AddStrings {
    public static void main(String[] args) {
        System.out.println(addStrings("11","999"));
    }
    public static String addStrings(String num1, String num2) {
        if(num1.length()>=num2.length()) return solve(new StringBuilder(num1),new StringBuilder(num2),0).toString();
        return solve(new StringBuilder(num2),new StringBuilder(num1),0).toString();
    }

    private static StringBuilder solve(StringBuilder num1, StringBuilder num2,int carry) {
        if(num1.isEmpty()){
            StringBuilder sb=new StringBuilder();
            return carry==0?sb:sb.append("1");
        }
        if(num2.isEmpty()){
            if(carry==0) return num1;
            return solve(num1,new StringBuilder("1"),0);
        }
        int c=num1.charAt(num1.length()-1)+num2.charAt(num2.length()-1)+carry-96;
        carry=c/10;
        c=c%10;
        char ch=(char)(c+'0');
        return solve(num1.deleteCharAt(num1.length()-1),num2.deleteCharAt(num2.length()-1),carry).append(ch);
    }
}
