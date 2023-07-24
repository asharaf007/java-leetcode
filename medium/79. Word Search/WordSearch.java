package Java.leetcodeSolution.medium;
//https://leetcode.com/problems/word-search/
public class WordSearch {
    public boolean exist(char[][] board, String word) {
        boolean[][] visited=new boolean[board.length][board[0].length];
        for(int row=0;row<board.length;row++){
            for(int col=0;col<board[0].length;col++){
                if(board[row][col]==word.charAt(0)&&solve(board,visited,word,row,col,0)){
                    return true;
                }
            }
        }
        return false;
    }

    private boolean solve(char[][] board,boolean[][] visited, String word, int row, int col, int i) {
        if(i==word.length()){
            return true;
        }
        if(row==board.length||row<0||col==board[0].length||col<0||visited[row][col]||word.charAt(i)!=board[row][col]){
            return false;
        }
        visited[row][col]=true;
        boolean right=solve(board,visited,word,row,col+1,i+1);
        boolean left=solve(board,visited,word,row+1,col,i+1);
        boolean up=solve(board,visited,word,row,col-1,i+1);
        boolean down=solve(board,visited,word,row-1,col,i+1);
        visited[row][col]=false;
        return right||left||up||down;
    }
}
