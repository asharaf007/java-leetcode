package Java.leetcodeSolutions.hard;
//Question Link Below
//https://leetcode.com/problems/max-points-on-a-line/
import java.util.HashMap;
import java.util.Map;

public class MaxPointsOnAline {
    public static void main(String[] args) {
        int[][] points={{1,1},{3,2},{5,3},{4,1},{2,3},{1,4}};
        System.out.println(maxPoints(points));
    }
    public static int maxPoints(int[][] points) {
        int n=points.length;
        if(n<3){
            return n;
        }
        int result=0;
        //map for tracking number of lines having that same slope
        HashMap<Double,Integer> hash=new HashMap<>();
        for(int i=0;i<n;i++){
            hash.clear();
            int samex=1;
            for(int j=0;j<n;j++){
                if(i!=j){
                    double x_diff=points[j][0]-points[i][0];
                    double y_diff=points[j][1]-points[i][1];
                    if(x_diff==0){
                        samex++;
                    }
                    else {
                        double slope = y_diff / x_diff;
                        if (hash.containsKey(slope)) {
                            hash.put(slope, hash.get(slope) + 1);
                        } else {
                            hash.put(slope, 2);
                        }
                    }
                }
            }
            for (Map.Entry<Double, Integer> set :
                    hash.entrySet()) {
                if(set.getValue()>result){
                    result=set.getValue();
                }
            }
            result=Math.max(result,samex);
        }
        return result;
    }
}
