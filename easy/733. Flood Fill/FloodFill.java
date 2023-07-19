package Java.leetcodeSolutions.easy;
//question link
//https://leetcode.com/problems/flood-fill/description/
public class FloodFill {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if(image[sr][sc]==color){
            return image;
        }
        fill(image,sr,sc,color,image[sr][sc]);
        return image;
    }
    private void fill(int[][] image, int sr, int sc, int color,int original) {
        if(sr<0||sc<0||sr==image.length||sc==image[0].length||image[sr][sc]!=original){
            return;
        }
        image[sr][sc]=color;
        fill(image,sr+1,sc,color,original);
        fill(image,sr-1,sc,color,original);
        fill(image,sr,sc+1,color,original);
        fill(image,sr,sc-1,color,original);
    }
}
