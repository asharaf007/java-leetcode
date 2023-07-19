package Java.leetcodeSolutions.medium;

import java.util.Arrays;
//question link
//https://leetcode.com/problems/task-scheduler/
public class TaskScheduler {
    public static void main(String[] args) {
        char[]tasks={'A','A','B','B'};
        System.out.println(leastInterval(tasks,2));
    }
    public static  int leastInterval(char[] tasks, int n) {
        int[] freq=new int[26];
        for (char task : tasks) freq[task - 'A']++;
        Arrays.sort(freq);
        int max_freq=freq[25];
        int max_freq_count=1;
        for(int i=24;i>=0;i--)if(freq[i]==max_freq)max_freq_count++;
        return Math.max(tasks.length,(max_freq-1)*(n+1)+max_freq_count);
    }
}
