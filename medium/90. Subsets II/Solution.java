//https://leetcode.com/problems/subsets-ii/
class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans =new ArrayList<>();
        helper(nums,-1,ans,new ArrayList<>());
        return ans;
    }
    private void helper(int[] nums,int i,List<List<Integer>> ans,List<Integer> sub){
        ans.add(new ArrayList<>(sub));
        for(int j=i+1;j<nums.length;j++){
            if(j>i+1&&nums[j]==nums[j-1]){
                continue;
            }
            sub.add(nums[j]);
            helper(nums,j,ans,sub);
            sub.remove(sub.size()-1);
        }
    }
}