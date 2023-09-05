package Java.leetcodeSolution.medium;
//Question Link Below
//https://leetcode.com/problems/sort-colors/
import java.util.Arrays;

public class SortColors {
    public static void main(String[] args) {
        int[] colors={2,0,2,0,1,2};
        sortColors(colors);
        System.out.println(Arrays.toString(colors));
    }
    public static void sortColors(int[] nums) {
        int i=0;
        int j=nums.length-1;
        int k=0;
        while(k<=j){
            if(nums[k]==2){
                swap(nums,k,j);
                j--;
            }
            else if(k>i&&nums[k]==0){
                swap(nums,k,i);
                i++;
            }
            else{
                k++;
            }
        }
    }
    public static void swap(int[] arr,int a,int b){
        int temp=arr[a];
        arr[a]=arr[b];
        arr[b]=temp;
    }
}
