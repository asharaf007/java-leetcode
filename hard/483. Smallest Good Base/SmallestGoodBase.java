package Java.leetcodeSolution.hard;
//https://leetcode.com/problems/smallest-good-base/
public class SmallestGoodBase {
    public static void main(String[] args) {
        System.out.println(smallestGoodBase("470988884881403701"));

    }
    public static String smallestGoodBase(String n) {
        long num=Long.parseLong(n);
        int bit=(int)(Math.log(num+1)/Math.log(2));
        while(bit>1){
            long right=num-1,left=2;
            while(left<=right){
                long mid=left+(right-left)/2;
                long ans=0;long pow=1;
                for(int i=1;i<=bit;i++){
                    if(ans>num)break;
                    ans+=pow;
                    if(i<bit&&(Long.MAX_VALUE-ans)/mid<pow){
                        ans=Long.MAX_VALUE;break;
                    }
                    else pow*=mid;
                }
                if(ans==num) return Long.toString(mid);
                if(ans>num) right=mid-1;
                else left=mid+1;
            }
            bit--;
        }
        return Long.toString(num-1);
    }
}
