package Java.leetcodeSolution.medium;
//https://leetcode.com/problems/operations-on-tree/
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LockingTree {
    int[] parent;
    List<Integer>[] children;
    int[] locker;
    public LockingTree(int[] parent) {
        this.parent = parent;
        children=new List[parent.length];
        locker=new int[parent.length];
        for(int i=0;i< parent.length;i++){
            children[i]=new ArrayList<>();
            locker[i]=-1;
        }
        for(int i=1;i< parent.length;i++) children[parent[i]].add(i);
    }
    public boolean lock(int num, int user) {
        if(locker[num]!=-1) return false;
        locker[num]=user;
        return true;
    }

    public boolean unlock(int num, int user) {
        if(locker[num]!=user) return false;
        locker[num]=-1;
        return true;
    }
    public boolean upgrade(int num, int user) {
        //The node is unlocked
        if(locker[num]!=-1) return false;
        //It does not have any locked ancestors.
        if(hasAnyAncestorLocked(num)) return false;
        //It has at least one locked descendant (by any user)
        if(!hasAnyDescendantLocked(num)) return false;
        unlockAllDescendant(num);
        locker[num]=user;
        return true;
    }
    private void unlockAllDescendant(int num) {
        List<Integer> child=children[num];
        for(int i=0;i<child.size();i++){
            locker[child.get(i)]=-1;
            unlockAllDescendant(child.get(i));
        }
    }
    private boolean hasAnyAncestorLocked(int num) {
        while(num!=0){
            int root=parent[num];
            if(locker[root]!=-1) return true;
            num=root;
        }
        return false;
    }
    private boolean hasAnyDescendantLocked(int num){
        List<Integer> child=children[num];
        for(int i=0;i<child.size();i++){
            if(locker[child.get(i)]!=-1||hasAnyDescendantLocked(child.get(i))) return true;
        }
        return false;
    }
}
