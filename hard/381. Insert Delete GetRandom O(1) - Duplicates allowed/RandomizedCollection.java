package Java.leetcodeSolution.hard;
//https://leetcode.com/problems/insert-delete-getrandom-o1-duplicates-allowed/

import java.util.*;

public class RandomizedCollection {
    Map<Integer, Set<Integer>> collection;
    Random rand;
    List<Integer> random;

    public RandomizedCollection() {
        collection = new HashMap<>();
        rand = new Random();
        random = new ArrayList<>();
    }

    public boolean insert(int val) {
        boolean ans = !collection.containsKey(val);
        if (ans) collection.put(val, new HashSet<>());
        collection.get(val).add(random.size());
        random.add(val);
        return ans;
    }

    public boolean remove(int val) {
        if (!collection.containsKey(val)) return false;
        int lastVal = random.get(random.size() - 1);
        int indexToRemove = collection.get(val).iterator().next();
        if (collection.get(val).size() == 1) collection.remove(val);
        else collection.get(val).remove(indexToRemove);
        if (indexToRemove < random.size() - 1) {
            random.set(indexToRemove, lastVal);
            collection.get(lastVal).remove(random.size() - 1);
            collection.get(lastVal).add(indexToRemove);
        }
        random.remove(random.size() - 1);
        return true;
    }

    public int getRandom() {
        return random.get(rand.nextInt(random.size()));
    }
}
