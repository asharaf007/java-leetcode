//https://leetcode.com/problems/combination-sum-ii/
class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> ans=new ArrayList<>();
        helper(ans,new ArrayList<>(),candidates,0,target);
        return ans;
    }
    private void helper(List<List<Integer>> a,List<Integer> s,int[] c,int i,int t){
        if(t==0){
            a.add(new ArrayList<>(s));
            return;
        }
        if(i==c.length||c[i]>t){
            return;
        }
        for(int j=i;j<c.length;j++){
            if(j>i&&c[j]==c[j-1]){
                continue;
            }
            s.add(c[j]);
            helper(a,s,c,j+1,t-c[j]);
            s.remove(s.size()-1);
        }
    }
}