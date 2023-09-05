package Java.leetcodeSolution.hard;
//https://leetcode.com/problems/minimum-cost-to-merge-stones/
public class MergeStones {
    public static void main(String[] args) {
        int[] stones={3,5,1,2,6};
        System.out.println(mergeStones(stones,3));
    }
    public static int mergeStones(int[] stones, int k) {
        return solve(stones,0,k);
    }
    public static int solve(int[] nums,int cost,int k){
        if(nums.length==1){
            return cost;
        }
        if(nums.length<k){
            return -1;
        }
        int index=0;
        int sum=0;
        for (int i = 0; i < k; i++) {
            sum+=nums[i];
        }
        for (int i = 1; i < nums.length-k+1; i++) {
            int tempSum=0;
            for(int j=i;j<i+k;j++){
                tempSum+=nums[j];
            }
            if(tempSum<sum){
                index=i;
                sum=tempSum;
            }
        }
        int[] newNums=new int[nums.length-k+1];
        int i=0;
        for(;i<index;i++){
            newNums[i]=nums[i];
        }
        newNums[i]=sum;
        for(i=i+k;i<nums.length;i++){
            newNums[i-k+1]=nums[i];
        }
        return solve(newNums,cost+sum,k);
    }
}
