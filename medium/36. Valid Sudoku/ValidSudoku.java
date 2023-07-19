package Java.leetcodeSolutions.medium;
//Question Link Below
//https://leetcode.com/problems/valid-sudoku/

import java.util.HashSet;

import static Java.leetcodeSolutions.hard.SudokuSolver.convert;

public class ValidSudoku {
    public static void main(String[] args) {
        int[][] matrix={
                {5,3,0,0,7,0,0,0,0},
                {6,0,0,0,1,4,5,0,0},
                {0,0,9,8,0,0,0,6,0},
                {8,0,0,0,6,0,0,0,3},
                {4,0,0,5,0,3,0,0,1},
                {7,0,0,0,2,0,0,0,6},
                {0,6,0,0,0,0,2,8,0},
                {0,0,0,4,3,9,0,0,5},
                {0,0,0,0,8,0,0,7,9}
        };
        char[][] board=convert(matrix);
        System.out.println(isValidSudoku(board));
    }


    public static boolean isValidSudoku(char[][] board){
        HashSet<Character> hash=new HashSet<>();
        //rows
        for(char[] row:board){
            for(char ch:row){
                if(ch!='.') {
                    if (hash.contains(ch)) {
                        return false;
                    }
                    hash.add(ch);
                }
            }
            hash.clear();
        }
        int r=0;
        int c=0;
        //columns
        for( c=0;c<9;c++){
            for (char[] chars : board) {
                if (chars[c] != '.') {
                    if (hash.contains(chars[c])) {
                        return false;
                    }
                    hash.add(chars[c]);
                }
            }
            hash.clear();
        }
        //3*3
        for( r=0;r<3;r++){
            for( c=0;c<3;c++){
                if (board[r][c] != '.') {
                    if (hash.contains(board[r][c])) {
                        return false;
                    }
                    hash.add(board[r][c]);
                }
            }
        }
        hash.clear();
        for( r=0;r<3;r++){
            for( c=3;c<6;c++){
                if (board[r][c] != '.') {
                    if (hash.contains(board[r][c])) {
                        return false;
                    }
                    hash.add(board[r][c]);
                }
            }
        }
        hash.clear();
        for( r=0;r<3;r++){
            for( c=6;c<9;c++){
                if (board[r][c] != '.') {
                    if (hash.contains(board[r][c])) {
                        return false;
                    }
                    hash.add(board[r][c]);
                }
            }
        }
        hash.clear();
        for( r=3;r<6;r++){
            for( c=0;c<3;c++){
                if (board[r][c] != '.') {
                    if (hash.contains(board[r][c])) {
                        return false;
                    }
                    hash.add(board[r][c]);
                }
            }
        }
        hash.clear();
        for( r=3;r<6;r++){
            for( c=3;c<6;c++){
                if (board[r][c] != '.') {
                    if (hash.contains(board[r][c])) {
                        return false;
                    }
                    hash.add(board[r][c]);
                }
            }
        }
        hash.clear();
        for( r=3;r<6;r++){
            for( c=6;c<9;c++){
                if (board[r][c] != '.') {
                    if (hash.contains(board[r][c])) {
                        return false;
                    }
                    hash.add(board[r][c]);
                }
            }
        }
        hash.clear();
        for( r=6;r<9;r++){
            for( c=0;c<3;c++){
                if (board[r][c] != '.') {
                    if (hash.contains(board[r][c])) {
                        return false;
                    }
                    hash.add(board[r][c]);
                }
            }
        }
        hash.clear();
        for( r=6;r<9;r++){
            for( c=3;c<6;c++){
                if (board[r][c] != '.') {
                    if (hash.contains(board[r][c])) {
                        return false;
                    }
                    hash.add(board[r][c]);
                }
            }
        }
        hash.clear();
        for( r=6;r<9;r++){
            for( c=6;c<9;c++){
                if (board[r][c] != '.') {
                    if (hash.contains(board[r][c])) {
                        return false;
                    }
                    hash.add(board[r][c]);
                }
            }
        }
        return true;
    }
}

