//https://leetcode.com/problems/snake-in-matrix/
public class Solution {
    public int finalPositionOfSnake(int n, List<String> commands) {
        int row=0;
        int col=0;
        for(int i=0;i<commands.size();i++){
            char com=commands.get(i).charAt(0);
            if(com=='U'){
                row--;
            }else if(com=='R'){
                col++;
            }else if(com=='D'){
                row++;
            }else{
                col--;
            }         
        }
        return (row*n)+col;
    }
}
