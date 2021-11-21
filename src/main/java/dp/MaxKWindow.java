package dp;

import java.util.Deque;
import java.util.LinkedList;

public class MaxKWindow {
    private static class Pair{
        int num;
        int index;

        Pair(int num, int index){
            this.num=num;
            this.index=index;
        }
    }
    public int[] maxInWindowOfK(int[] nums, int k){
        Deque<Pair> deque = new LinkedList<>();
        int[] ans = new int[nums.length-k+1];
        int j=0;
        for(int i=0; i< nums.length; i++){
            if(!deque.isEmpty() && deque.getFirst().index <= i-k){
                deque.removeFirst();
            }
            while (!deque.isEmpty() && deque.getLast().num < nums[i]){
                deque.removeLast();
            }
            deque.add(new Pair(nums[i], i));
            if(i > k){
                ans[j++] = deque.getFirst().num;
            }
        }
        return ans;
    }
}
