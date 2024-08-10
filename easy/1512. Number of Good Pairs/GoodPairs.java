import java.util.HashMap;
import java.util.Map;
//https://leetcode.com/problems/number-of-good-pairs/
public class GoodPairs {
    public int numIdenticalPairs(int[] arr){
        int res=0;
        Map<Integer,Integer> map=new HashMap<>();
        for(int num:arr){
            if(map.containsKey(num)){
                int count=map.get(num);
                res+=count;
                map.put(num,count+1);
            }else{
                map.put(num,1);
            }
        }
        return res;
    }
}
