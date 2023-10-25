package Java.leetcodeSolution.hard;
import java.util.ArrayList;
import java.util.List;
//https://leetcode.com/problems/count-of-smaller-numbers-after-self/
public class CountSmallerNumbersAfterSelf {
    public static void main(String[] args) {
        System.out.println(new CountSmallerNumbersAfterSelf().countSmaller(new int[]{5,2,6,1}));
    }
    class NumWithOrigindex{
        int val;
        int index;
        NumWithOrigindex(int val,int index){
            this.val=val;
            this.index=index;
        }
    }
    public List<Integer> countSmaller(int[] nums) {
        int n=nums.length;
        NumWithOrigindex[] numsP=new NumWithOrigindex[n];
        for(int i=0;i<n;i++) numsP[i]=new NumWithOrigindex(nums[i],i);
        int[] count=new int[n];
        enhancedMergeSort(numsP,0,n-1,count);
        List<Integer> ans=new ArrayList<>();
        for(int x:count) ans.add(x);
        return ans;
    }

    private void enhancedMergeSort(NumWithOrigindex[] numsP, int st, int end, int[] count) {
        if(st>=end) return;
        int mid=st+(end-st)/2;
        enhancedMergeSort(numsP, st, mid, count);
        enhancedMergeSort(numsP, mid+1, end, count);
        //merge
        NumWithOrigindex[] nums=new NumWithOrigindex[end-st+1];
        int i=st,j=mid+1,k=0,cnt=0;
        while(i<mid+1&&j<=end){
            if(numsP[i].val>numsP[j].val){
                cnt++;
                nums[k++]=numsP[j++];
            }
            else{
                count[numsP[i].index]+=cnt;
                nums[k++]=numsP[i++];
            }
        }
        while(i<mid+1){
            count[numsP[i].index]+=cnt;
            nums[k++]=numsP[i++];
        }
        while(j<=end) nums[k++]=numsP[j++];
        k=st;
        for(NumWithOrigindex x:nums) numsP[st++]=x;
    }
}
