package Java.leetcodeSolution.contest.week356;

//https://leetcode.com/contest/weekly-contest-356/problems/number-of-employees-who-met-the-target/
public class NoOfEmployees {
    public int numberOfEmployeesWhoMetTarget(int[] hours, int target) {
        int ans = 0;
        for (int num : hours) {
            if (num >= target) ans++;
        }
        return ans;
    }
}
