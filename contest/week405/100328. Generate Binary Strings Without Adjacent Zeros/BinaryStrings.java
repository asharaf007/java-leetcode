//https://leetcode.com/contest/weekly-contest-405/problems/generate-binary-strings-without-adjacent-zeros/
public class BinaryStrings {
    List<String> res;

    public List<String> validStrings(int n) {
        res = new ArrayList<>();
        helper(n, 1, new StringBuilder());
        return res;
    }

    private void helper(int n, int prev, StringBuilder sb) {
        if (n == 0) {
            res.add(sb.toString());
            return;
        }
        n--;
        sb.append("1");
        helper(n, 1, sb);
        sb.deleteCharAt(sb.length() - 1);
        sb.append("0");
        if (prev == 1) {
            helper(n, 0, sb);
        }
        sb.deleteCharAt(sb.length() - 1);
    }
}
