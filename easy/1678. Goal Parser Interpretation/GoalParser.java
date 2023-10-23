package Java.leetcodeSolution.easy;

//https://leetcode.com/problems/goal-parser-interpretation/
public class GoalParser {
    public String interpret(String command) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < command.length(); i++) {
            char ch = command.charAt(i);
            if (ch == 'G') sb.append(ch);
            else if (++i < command.length() && command.charAt(i) == ')') sb.append("o");
            else {
                sb.append("al");
                i += 2;
            }
        }
        return sb.toString();
    }
}
