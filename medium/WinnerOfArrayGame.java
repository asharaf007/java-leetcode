package Java.leetcodeSolution.medium;
//https://leetcode.com/problems/find-the-winner-of-an-array-game/
public class WinnerOfArrayGame {
    public int getWinner(int[] arr, int k) {
        int i=1,count=0,winner=arr[0];
        while(i<arr.length) {
            if(arr[i]>winner) {
                winner=arr[i];
                count=1;
            }
            else count++;
            if(count==k) break;
        }
        return winner;
    }

}
