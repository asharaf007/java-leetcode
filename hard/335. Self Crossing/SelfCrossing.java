package Java.leetcodeSolution.hard;
//https://leetcode.com/problems/self-crossing/
public class SelfCrossing {
    public static void main(String[] args) {
        System.out.println(isSelfCrossing(new int[]{2,1,4,2,5,3,10,6,4,5,3,4,2,3,1,2}));
    }
    public static boolean isSelfCrossing(int[] d) {
        for(int i=3;i<d.length;i++){
            if((d[i]>=d[i-2]&&d[i-1]<=d[i-3])
                    || (i>=4&&d[i-1]==d[i-3]&&d[i]+d[i-4]>=d[i-2])
                    || (i>=5&&d[i]+d[i-4]>=d[i-2]&&d[i-1]+d[i-5]>=d[i-3]&&d[i-2]>=d[i-4]&&d[i-3]>=d[i-1]))
                return true;
        }
        return false;
    }
}
