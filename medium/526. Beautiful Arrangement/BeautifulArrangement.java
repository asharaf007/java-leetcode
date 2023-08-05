package Java.leetcodeSolution.medium;
//https://leetcode.com/problems/beautiful-arrangement/
public class BeautifulArrangement {
    public static void main(String[] args) {
        BeautifulArrangement object=new BeautifulArrangement();
        System.out.println(object.countArrangement(15));
    }
    private boolean[] visited;
    public int countArrangement(int n) {
        this.visited=new boolean[n+1];
        return solve(n);
    }
    private int solve(int n){
        if(n==1){
            return 1;
        }
        int count=0;
        int size=visited.length;
        for(int j=1;j<size;j++){
            if(!visited[j]&&(isDivisible(j,n)||isDivisible(n,j))){
                //backtracking
                visited[j]=true;
                count+=solve(n-1);
                visited[j]=false;
            }
        }
        return count;
    }

    private boolean isDivisible(int a, int b) {
        return a%b==0;
    }


}
