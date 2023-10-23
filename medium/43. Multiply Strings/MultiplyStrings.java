package Java.leetcodeSolution.medium;

//https://leetcode.com/problems/multiply-strings/
public class MultiplyStrings {
    public static void main(String[] args) {
        System.out.println(multiply("9133", "0"));
    }

    public static String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) return "0";
        String ans = "";
        for (int i = num1.length() - 1; i >= 0; i--) {
            int carry = 0;
            StringBuilder sb = new StringBuilder();
            for (int j = num2.length() - 1; j >= 0; j--) {
                int num = (num2.charAt(j) - '0') * (num1.charAt(i) - '0') + carry;
                ;
                carry = num / 10;
                num %= 10;
                sb.insert(0, (char) (num + '0'));
            }
            if (carry > 0) sb.insert(0, (char) (carry + '0'));
            for (int k = num1.length() - i - 1; k > 0; k--) sb.append('0');
            ans = addStrings(ans, sb.toString());
        }
        return ans;
    }

    private static String addStrings(String num1, String num2) {
        StringBuilder sb = new StringBuilder();
        int i = num1.length() - 1, j = num2.length() - 1, carry = 0;
        while (i >= 0 || j >= 0 || carry > 0) {
            int num = 0;
            if (i >= 0) num += num1.charAt(i) - '0';
            if (j >= 0) num += num2.charAt(j) - '0';
            if (carry > 0) num += carry;
            carry = num / 10;
            num %= 10;
            sb.insert(0, (char) (num + '0'));
            i--;
            j--;
        }
        return sb.toString();
    }
}
