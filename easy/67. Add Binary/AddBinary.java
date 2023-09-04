package Java.leetcodeSolution.easy;
//https://leetcode.com/problems/add-binary/
public class AddBinary {
    public static void main(String[] args) {
        System.out.println(addBinary("1010","1011"));
    }
    public static String addBinary(String a, String b) {
        StringBuilder sb=new StringBuilder();
        int i=a.length()-1;
        int j=b.length()-1;
        int carry=0;
        while(i>=0||j>=0||carry==1){
            int num=0;
            if(carry==1) num++;
            if(i>=0&&a.charAt(i)=='1') num++;
            if(j>=0&&b.charAt(j)=='1') num++;
            carry=num/2;
            num%=2;
            char c=num==0?'0':'1';
            sb.insert(0,c);
            i--;j--;
        }
        return sb.toString();
    }
}
