package Java.leetcodeSolution.medium;

import java.util.ArrayList;
import java.util.List;
//https://leetcode.com/problems/count-nodes-with-the-highest-score/
public class CountNodesWHighScore {
    List<Integer>[] child;
    int[] count;
    int n;
    public int countHighestScoreNodes(int[] parents) {
        n= parents.length;
        child=new List[n];
        count=new int[n];
        for(int i=0; i<n; i++)child[i]=new ArrayList<>();
        for(int i=1;i<parents.length;i++) child[parents[i]].add(i);
        setCountOfAllNodes(0);
        int cnt=1;
        long max=0;
        for(int i=0;i<parents.length;i++){
            long ans=1;
            if(i!=0) ans*=n-count[i];
            for(int j=0;j<child[i].size();j++) ans*=count[child[i].get(j)];
            if(ans>max){
                cnt=1;
                max=ans;
            }
            else if(ans==max) cnt++;
        }
        return cnt;
    }
    private int setCountOfAllNodes(int index){
        int c=1;
        for(int i=0;i<child[index].size();i++) c+=setCountOfAllNodes(child[index].get(i));
        return count[index]=c;
    }
}
