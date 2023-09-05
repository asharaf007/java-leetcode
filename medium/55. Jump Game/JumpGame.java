package Java.leetcodeSolution.medium;
//Question Link Below
//https://leetcode.com/problems/jump-game/
public class JumpGame {
    public static void main(String[] args) {
        int [] nums={1,1,2,2,0,1,1};
        System.out.println(canJump(nums));

    }
    public static boolean canJump(int[] nums) {
        int reachable=0;
        for(int i=0;i<nums.length;i++){
            if(i>reachable)return false;
            reachable=Math.max(reachable,i+nums[i]);
        }
        return true;
    }

}
