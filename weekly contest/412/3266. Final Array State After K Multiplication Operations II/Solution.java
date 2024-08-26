//https://leetcode.com/problems/final-array-state-after-k-multiplication-operations-ii/
class Solution {
    static int mod=1000000007;
    public int[] getFinalState(int[] nums, int k, int multiplier) {
        if(multiplier==1){
            return nums;
        }
        int n=nums.length;
        PriorityQueue<long[]> pq=new PriorityQueue<>((a,b)->{
            if(a[0]==b[0]){
                return Long.compare(a[1],b[1]);
            }
            return Long.compare(a[0],b[0]);
        });
        int max=0;
        for(int i=0;i<n;i++){
            max=Math.max(max,nums[i]);
            pq.add(new long[]{nums[i],i});
        }
        while(k>0){
            long[] min=pq.poll();
            pq.add(new long[]{min[0]*multiplier,min[1]});
            k--;
            if(max==min[0]){
                break;
            }
        }
        long mul=modPow(multiplier,k/n,mod);
        k%=n;
        Queue<Integer> q=new LinkedList<>();
        while(!pq.isEmpty()){
            long[] min=pq.poll();
            q.add((int)min[1]);
            nums[(int)min[1]]=(int)(((min[0]%mod)*mul)%mod);
        }
        while(k>0){
            int i=q.poll();
            nums[i]=(int)((nums[i]*(long)multiplier)%mod);
            k--;
        }
        return nums;
    }
    private long modPow(long base, long exponent, long mod) {
        long result = 1;
        while (exponent > 0) {
            if ((exponent & 1) == 1) { // If exponent is odd
                result = (result * base) % mod;
            }
            base = (base * base) % mod;
            exponent >>= 1; // Divide exponent by 2
        }
        return result;
    }
}
