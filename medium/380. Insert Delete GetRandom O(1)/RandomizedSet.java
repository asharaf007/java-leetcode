package Java.leetcodeSolution.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

//https://leetcode.com/problems/insert-delete-getrandom-o1/
public class RandomizedSet {
    private Random random;
    private HashMap<Integer, Integer> map;
    private List<Integer> list;

    public RandomizedSet() {
        map = new HashMap<>();
        list = new ArrayList<>();
        random = new Random();
    }

    public boolean insert(int val) {
        if (map.containsKey(val)) return false;
        map.put(val, list.size());
        list.add(val);
        return true;
    }

    public boolean remove(int val) {
        if (!map.containsKey(val)) return false;
        int indexToRemove = map.get(val);
        int lastVal = list.remove(list.size() - 1);//deletes last index of list
        if (lastVal != val) { //if lastVal!=val
            list.set(indexToRemove, lastVal);
            map.put(lastVal, indexToRemove);
        }
        map.remove(val);
        return true;
    }

    public int getRandom() {
        return list.get(random.nextInt(list.size()));
    }
}