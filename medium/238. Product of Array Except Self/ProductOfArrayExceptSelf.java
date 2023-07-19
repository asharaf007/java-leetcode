package Java.leetcodeSolutions.medium;
//Question Link Below
//https://leetcode.com/problems/product-of-array-except-self/

import java.util.Arrays;

public class ProductOfArrayExceptSelf {
    public static void main(String[] args) {
        int[] nums={1,-3,-3,4};
        System.out.println(Arrays.toString(productExceptSelfWoDivision(nums)));
        System.out.println(Arrays.toString(productExceptSelf(nums)));
    }
    public static int[] productExceptSelf(int[] nums) {
        int[] ans=new int[nums.length];
        int p=1,zero=0;
        for(int i=0;i<nums.length;i++){
            if(!(nums[i]==0)){
                p*=nums[i];
            }
            else{
                zero++;
            }
        }
        if(zero>1){
            return ans;
        }
        if(zero==1){
            for(int i=0;i<nums.length;i++){
                if(nums[i]==0){
                    ans[i]=p;
                    return ans;
                }
            }
        }
        for(int i=0;i<nums.length;i++){
            ans[i]=p/nums[i];
        }
        return ans;
    }
    public static int[] productExceptSelfWoDivision(int[] nums){
        int[] left=new int[nums.length];
        left[0]=1;
        for(int i=1;i<nums.length;i++){
            left[i]=left[i-1]*nums[i-1];
        }
        int right=1;
        for(int j=nums.length-1;j>=0;j--){
            left[j]*=right;
            right*=nums[j];
        }
        return left;
    }
}
