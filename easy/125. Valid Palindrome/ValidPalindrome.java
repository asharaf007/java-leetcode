package Java.leetcodeSolution.easy;

//https://leetcode.com/problems/valid-palindrome/
public class ValidPalindrome {
    public static void main(String[] args) {
        System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
    }

    public static boolean isPalindrome(String s) {
        int i = 0, j = s.length() - 1;
        while (i < j) {
            while (i < j && (s.charAt(i) < 48 || (s.charAt(i) > 57 && s.charAt(i) < 65) || (s.charAt(i) > 90 && s.charAt(i) < 97) || s.charAt(i) > 122))
                i++;
            while (i < j && (s.charAt(j) < 48 || (s.charAt(j) > 57 && s.charAt(j) < 65) || (s.charAt(j) > 90 && s.charAt(j) < 97) || s.charAt(j) > 122))
                j--;
            if (i < j) {
                char c1 = s.charAt(i), c2 = s.charAt(j);
                c1 += c1 >= 65 && c1 <= 90 ? 32 : 0;
                c2 += c2 >= 65 && c2 <= 90 ? 32 : 0;
                if (Math.abs(c1 - c2) != 0) return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
