package Java.leetcodeSolution.medium;
//https://leetcode.com/problems/build-an-array-with-stack-operations/
import java.util.List;
import java.util.ArrayList;
public class BuildAnArray {
    public List<String> buildArray(int[] target, int n) {
        List<String> result = new ArrayList<String>();
        int j=0;
        for(int i=1;i<=n;i++){
            result.add("push");
            if(i!=target[j]) result.add("pop");
            else j++;
            if(j==target.length) break;
        }
        return result;
    }
}
