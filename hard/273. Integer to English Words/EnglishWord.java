package Java.leetcodeSolution.hard;

//https://leetcode.com/problems/integer-to-english-words/
public class EnglishWord {
    public static void main(String[] args) {
//        System.out.println(threeDigitWords(817,3));
        System.out.println(numberToWords(5001));
    }

    private static final String[] ones = {"", " One", " Two", " Three", " Four", " Five", " Six", " Seven", " Eight", " Nine"};
    private static final String[] tens = {"", "", " Twenty", " Thirty", " Forty", " Fifty", " Sixty", " Seventy", " Eighty", " Ninety"};
    private static final String[] tens1 = {" Ten", " Eleven", " Twelve", " Thirteen", " Fourteen", " Fifteen", " Sixteen", " Seventeen", " Eighteen", " Nineteen"};
    private static final String[] suffix = {"", " Thousand", " Million", " Billion"};

    public static String numberToWords(int num) {
        if (num == 0) {
            return "Zero";
        }
        return solve(num).substring(1);
    }

    private static String solve(int num) {
        if (num == 0) {
            return "";
        }
        int size = Integer.toString(num).length();
        int dividend = (int) Math.pow(10, size - (size % 3 == 0 ? 3 : size % 3));
        int rem = num % dividend;
        num /= dividend;
        String temp = solve(rem);
        return threeDigitWords(num) + suffix[(size - 1) / 3] + temp;
    }

    private static String threeDigitWords(int num) {
        int n = Integer.toString(num).length();
        if (n == 1) {
            return ones[num];
        }
        int dividend = (int) (Math.pow(10, n - 1));
        int rem = num % dividend;
        num /= dividend;
        if (n == 2) {
            if (num == 1)
                return tens1[rem];
            return tens[num] + threeDigitWords(rem);
        }
        String small = threeDigitWords(rem);
        return ones[num] + " Hundred" + small;
    }
}
