package Java.leetcodeSolution.hard;

import java.util.ArrayList;
import java.util.List;

//Question Link Below
//https://leetcode.com/problems/n-queens/
public class NQueens {
    public static void main(String[] args) {
        int n = 4;
        System.out.println(solveNQueens(n));
    }
    private static boolean[][] visited;

    public static List<List<String>> solveNQueens(int n) {
        visited = new boolean[n][n];
        return waysPrint(0, new ArrayList<>(), new ArrayList<>());
    }

    private static List<List<String>> waysPrint(int r, List<String> l, List<List<String>> ll) {
        if (r == visited.length) {
            List<String> list = new ArrayList<>(l);
            ll.add(list);
            return ll;
        }
        for (int i = 0; i < visited.length; i++) {
            if (isSafe(r, i)) {
                l.add(getString(i));
                visited[r][i] = true;
                waysPrint(r + 1, l, ll);
                visited[r][i] = false;
                l.remove(l.size() - 1);
            }
        }
        return ll;
    }

    public static boolean isSafe(int r, int c) {
        int i = r - 1;
        int j = c - 1;
        while (i >= 0 && j >= 0) {
            if (visited[i][j]) {
                return false;
            }
            i--;
            j--;
        }
        i = r - 1;
        j = c;
        while (i >= 0) {
            if (visited[i][j]) {
                return false;
            }
            i--;
        }
        i = r - 1;
        j = c + 1;
        while (i >= 0 && j < visited.length) {
            if (visited[i][j]) {
                return false;
            }
            i--;
            j++;
        }
        return true;
    }

    private static String getString(int index) {
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < visited.length; i++) {
            if (i == index) s.append("Q");
            else s.append(".");
        }
        return s.toString();
    }
}
