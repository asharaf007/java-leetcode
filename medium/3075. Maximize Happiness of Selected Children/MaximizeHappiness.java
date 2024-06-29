import java.util.Arrays;
import java.util.Collections;

public class MaximizeHappiness {
    public static void main(String[] args) {
        MaximizeHappiness obj = new MaximizeHappiness();
        int[] happiness = {5,2,7,9,9,3,6,7,8,8,7,9,3,0,4,2,3,9,8,5,6,4,8,9};
        int k = 8;
        System.out.println(obj.maximumHappinessSum(happiness, k));
    }

    public long maximumHappinessSum(int[] happiness, int k) {
        long res = 0;
        Integer[] arr=new Integer[happiness.length];
        for(int i=0;i<happiness.length;i++){
            arr[i]=happiness[i];
        }
        Arrays.sort(arr,Collections.reverseOrder());
        for (int i = 0; i < k; i++) {
            int curr=arr[i]-i;
            if(curr>0){
                res+=curr;
            }
        }
        return res;
    }
    private void quickSort(int[] array,int st,int end){
        if(st>=end){
            return;
        }
        int rightPos=st;
        for(int i=st+1;i<=end;i++){
            if(array[i]>=array[st]){
                rightPos++;
            }
        }
        int temp=array[st];
        array[st]=array[rightPos];
        array[rightPos]=temp;
        int i=st,j=end;
        while(i<rightPos&&j>rightPos){
            if(array[i]>=temp){
                i++;
            }else if(array[j]<temp){
                j--;
            }else{
                int t=array[i];
                array[i]=array[j];
                array[j]=t;
                i++;
                j--;
            }
        }
        quickSort(array,st,rightPos-1);
        quickSort(array,rightPos+1,end);
    }
}
