package Java.leetcodeSolutions.hard;

import java.util.ArrayList;
import java.util.List;
//Question Link Below
//https://leetcode.com/problems/n-queens/
public class NQueens {
    public static void main(String[] args) {
        int n=4;
        System.out.println(solveNQueens(n));
    }
    public static List<List<String>> solveNQueens(int n) {
        //https://leetcode.com/problems/n-queens/
        boolean[][] visited=new boolean[n][n];
        StringBuilder s= new StringBuilder("");
        for(int i=0;i<n;i++){
            s.append(".");
        }
        return waysPrint(visited,0,s.toString(),new ArrayList<>(),new ArrayList<>());
    }
    static  List<List<String>> waysPrint(boolean[][] visited, int r,String s,List<String> l,List<List<String>> ll){
        //https://leetcode.com/problems/n-queens/
        if(r==visited.length){
            ll.add(l);
            return ll;
        }
        for(int i=0;i<visited[0].length;i++){
            if(safe(visited,r,i)){
                String ns=s.substring(0,i)+"Q"+s.substring(i+1);
                l.add(ns);
                ArrayList<String> nl=new ArrayList<>(l);
                visited[r][i]=true;
                waysPrint(visited,r+1,s,nl,ll);
                visited[r][i]=false;
                l.remove(l.size()-1);
            }
        }
        return ll;
    }
    static boolean safe(boolean[][] visited,int r, int c){
        int i=r-1;
        int j=c-1;
        while(i>=0&&j>=0){
            if(visited[i][j]){
                return false;
            }
            i--;
            j--;
        }
        i=r-1;
        j=c;
        while(i>=0){
            if(visited[i][j]){
                return false;
            }
            i--;
        }
        i=r-1;
        j=c+1;
        while(i>=0&&j<visited[0].length){
            if(visited[i][j]){
                return false;
            }
            i--;
            j++;
        }
        return true;
    }
}
