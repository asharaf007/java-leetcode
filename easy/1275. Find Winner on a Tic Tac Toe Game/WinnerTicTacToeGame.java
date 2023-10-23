package Java.leetcodeSolution.easy;

//question link
//https://leetcode.com/problems/find-winner-on-a-tic-tac-toe-game/
public class WinnerTicTacToeGame {
    public static void main(String[] args) {
        int[][] moves = {{0, 2}, {1, 0}, {2, 2}, {1, 2}, {2, 0}, {0, 0}, {0, 1}, {2, 1}, {1, 1}};
        System.out.println(tictactoe(moves));
    }

    public static String tictactoe(int[][] moves) {
        char[][] board = new char[3][3];
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[0].length; col++) {
                board[row][col] = ' ';
            }
        }
        char player = 'A';
        for (int[] move : moves) {
            int row = move[0];
            int col = move[1];
            board[row][col] = player;
            if (isGameOver(board, player, row, col)) {
                return player + "";
            }
            player = (player == 'A') ? 'B' : 'A';
        }
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[0].length; col++) {
                if (board[row][col] == ' ') return "Pending";
            }
        }
        return "Draw";
    }

    private static boolean isGameOver(char[][] board, char player, int row, int col) {
        //row
        if (board[row][0] == player && board[row][1] == player && board[row][2] == player) {
            return true;
        }
        //col
        if (board[0][col] == player && board[1][col] == player && board[2][col] == player) {
            return true;
        }
        //diagonal
        if ((row == 1 && col == 1)) {
            return (board[0][0] == player && board[1][1] == player && board[2][2] == player) || (board[2][0] == player && board[1][1] == player && board[0][2] == player);
        }
        if ((row == 0 && col == 0) || (row == 2 && col == 2)) {
            return board[0][0] == player && board[1][1] == player && board[2][2] == player;
        }
        if ((row == 2 && col == 0) || (row == 0 && col == 2)) {
            return board[2][0] == player && board[1][1] == player && board[0][2] == player;
        }
        return false;
    }
}
