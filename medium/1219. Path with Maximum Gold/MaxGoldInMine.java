package Java.leetcodeSolution.medium;
//https://leetcode.com/problems/path-with-maximum-gold/
public class MaxGoldInMine {
    public static void main(String[] args) {
        int[][] grid={{0,6,0},{5,8,7},{0,9,0}};
        System.out.println(getMaximumGold(grid));
    }
    public static int getMaximumGold(int[][] grid) {
        int max=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]!=0)
                    max=Math.max(max,solve(grid,i,j));
            }
        }
        return max;
    }

    private static int solve(int[][] grid, int i, int j) {
        if(i==-1||i==grid.length||j==-1||j==grid[0].length||grid[i][j]==0){
            return 0;
        }
        int val=grid[i][j];
        grid[i][j]=0;
        int right=solve(grid,i,j+1);
        int left=solve(grid,i,j-1);
        int up=solve(grid,i-1,j);
        int down=solve(grid,i+1,j);
        grid[i][j]=val;
        return Math.max(Math.max(right,left),Math.max(up,down))+val;
    }

}
