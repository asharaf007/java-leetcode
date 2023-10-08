package Java.leetcodeSolution.hard;
//https://leetcode.com/problems/check-if-string-is-transformable-with-substring-sort-operations/
import java.util.Queue;
import java.util.ArrayDeque;

public class IsStringTransformable {
    public static void main(String[] args) {
        System.out.println(isTransformable("84532", "34852"));
    }
    public static boolean isTransformable(String s, String t) {
        char[] s1=s.toCharArray(),t1=t.toCharArray();
        Queue<Integer>[] indexes=new ArrayDeque[10];
        for(int i=0;i<10;i++)indexes[i]=new ArrayDeque<>();
        for(int i=0;i<s1.length;i++)indexes[s1[i]-'0'].add(i);
        for(int i=0;i<t1.length;i++){
            int index=t1[i]-'0';
            if(indexes[index].size()==0) return false;
            for(int j=0;j<index;j++)if(indexes[j].size()>0&&indexes[j].peek()<indexes[index].peek()) return false;
            indexes[index].remove();
        }
        return true;
    }
}
