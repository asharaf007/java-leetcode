//https://leetcode.com/problems/kids-with-the-greatest-number-of-candies/
public class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int max=candies[0];
        for(int i=1;i<candies.length;i++){
            max=Math.max(max,candies[i]);
        }
        List<Boolean> res=new ArrayList<>();
        for(int candy:candies){
            res.add(candy+extraCandies>=max);
        }
        return res;
    }
}
