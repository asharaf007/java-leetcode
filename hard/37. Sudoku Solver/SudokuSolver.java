package Java.leetcodeSolution.hard;

//Question Link Below
//https://leetcode.com/problems/sudoku-solver/
public class SudokuSolver {
    public static void main(String[] args) {
        int[][] matrix = {
                {5, 3, 0, 0, 7, 0, 0, 0, 0},
                {6, 0, 0, 0, 1, 9, 5, 0, 0},
                {0, 9, 8, 0, 0, 0, 0, 6, 0},
                {8, 0, 0, 0, 6, 0, 0, 0, 3},
                {4, 0, 0, 8, 0, 3, 0, 0, 1},
                {7, 0, 0, 0, 2, 0, 0, 0, 6},
                {0, 6, 0, 0, 0, 0, 2, 8, 0},
                {0, 0, 0, 4, 1, 9, 0, 0, 5},
                {0, 0, 0, 0, 8, 0, 0, 7, 9}
        };
        solveSudoku(matrix);
    }

    public static void solveSudoku(int[][] matrix) {
        char[][] board = convert(matrix);
//        solve1(board,0,0);
        System.out.println(solve2(board, 0, 0));
        for (char[] a : board) {
            System.out.println(a);
        }
    }

    public static void solve1(char[][] board, int r, int c) {

        //if we go out of matrix means we checked all position so, we should simply return
        if (r == board.length - 1 && c == board[0].length) {
            return;
        }
        //if column is ended then we call for next row and first column and return
        if (c == board[0].length) {
            solve1(board, r + 1, 0);
            return;
        }
        //if position is empty then we will check by putting 1 to 9 one by one
        if (board[r][c] == '.') {
            for (int i = 1; i <= board[0].length; i++) {
                char ch = (char) (i + '0');
                //if ch is safe to be placed then we place i and call for next column in this row
                if (isSafe(board, r, c, ch)) {
                    board[r][c] = ch;
                    solve1(board, r, c + 1);
                    //if there are no empty position means sudoku is solved then return
                    if (isSudokuSolved(board)) {
                        return;
                    }
                    //otherwise backtrack
                    board[r][c] = '.';
                }
            }
        }
        //if not empty call for next column in this row
        else {
            solve1(board, r, c + 1);
        }
    }

    public static boolean solve2(char[][] board, int r, int c) {
        //if out of matrix means we have already checked all cells and sudoku is solved
        if (r == board.length - 1 && c == board.length) {
            return true;
        }
        if (c == board.length) {//if column out of bound then call for first cell of next row
            return solve2(board, r + 1, 0);
        }
        //if cell is empty then try to put 1-9 on this cell one by one
        if (board[r][c] == '.') {
            for (int i = 1; i <= board.length; i++) {
                char ch = (char) (i + '0');
                //if it is safe to put this number on this cell then put and call for next cell
                if (isSafe(board, r, c, ch)) {
                    board[r][c] = ch;
                    //by putting this number if sudoku will be solved then simply return true
                    //no need to check for next number
                    if (solve2(board, r, c + 1)) {
                        return true;
                    }
                    //otherwise backtrack
                    board[r][c] = '.';
                }
            }
            //if we cannot put any value on this cell then sudoku can not be solved
            //no need to check further
            return false;
        }
        //if cell is occupied then just call for next cell
        return solve2(board, r, c + 1);
    }

    public static char[][] convert(int[][] matrix) {
        int n = matrix.length;
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    board[i][j] = '.';
                } else {
                    char ch = (char) (matrix[i][j] + '0');
                    board[i][j] = ch;
                }
            }
        }
        return board;
    }

    public static boolean isSafe(char[][] board, int r, int c, char ch) {
        //vertically check
        for (char[] a : board) {
            if (a[c] == ch) {
                return false;
            }
        }
        //horizontal check
        for (int i = 0; i < board[0].length; i++) {
            if (board[r][i] == ch) {
                return false;
            }
        }
        //cube check
        int sqrt = (int) Math.sqrt(board.length);
        int startRow = r - (r % sqrt);
        int startCol = c - (c % sqrt);
        for (int row = startRow; row < startRow + sqrt; row++) {
            for (int col = startCol; col < startCol + sqrt; col++) {
                if (board[row][col] == ch) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean isSudokuSolved(char[][] board) {
        for (char[] chars : board) {
            for (int c = 0; c < board[0].length; c++) {
                if (chars[c] == '.') {
                    return false;
                }
            }
        }
        return true;
    }
}
