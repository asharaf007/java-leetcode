package Java.leetcodeSolution.hard;

import java.util.*;
import java.util.concurrent.PriorityBlockingQueue;

//https://leetcode.com/problems/smallest-missing-genetic-value-in-each-subtree/
public class SmallestMissingValue {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new SmallestMissingValue().smallestMissingValueSubtree(new int[ ]{-1,0,1,0,3,3},new int[]{5,4,6,2,1,3})));
    }
    boolean[] visited=new boolean[100002];
    List<Integer>[] childs;
    public int[] smallestMissingValueSubtree(int[] parents, int[] nums) {
        int[] missed=new int[parents.length];
        Arrays.fill(missed,1);
        childs=new List[parents.length];
        for(int i=0; i<parents.length; i++) childs[i]=new ArrayList<>();
        for(int j=1; j<parents.length; j++){
            childs[parents[j]].add(j);
        }
        int index_one=-1;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==1){
                index_one=i;
                break;
            }
        }
        if(index_one==-1) return missed;
        int currMissingNum=2;
        while(index_one!=-1){
            helper(index_one,nums);
            while(visited[currMissingNum]){
                currMissingNum++;
            }
            missed[index_one]=currMissingNum;
            index_one=parents[index_one];
        }
        return missed;
    }
    void helper(int node,int[]nums){
        if(visited[nums[node]]) return;
        visited[nums[node]]=true;
        for(int num:childs[node]){
            helper(num,nums);
        }
    }
}
