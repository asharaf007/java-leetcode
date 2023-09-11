package Java.leetcodeSolution.easy;
//https://leetcode.com/problems/add-strings/
public class AddStrings {
    public static void main(String[] args) {
        System.out.println(addStrings("11","999"));
    }
    public static String addStrings(String num1, String num2) {
        StringBuilder sb=new StringBuilder();
        int i=num1.length()-1,j=num2.length()-1,carry=0;
        while(i>=0||j>=0||carry>0){
            int num=0;
            if(i>=0) num+=num1.charAt(i)-'0';
            if(j>=0) num+=num2.charAt(j)-'0';
            if(carry>0) num+=carry;
            carry=num/10;
            num%=10;
            sb.insert(0,(char)(num+'0'));
            i--;j--;
        }
        return sb.toString();
    }
}
