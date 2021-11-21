package dp;

import java.util.Arrays;

/**
 * Given an integer array nums, return the length of the longest strictly increasing subsequence.
 *
 * A subsequence is a sequence that can be derived from an array by deleting some or no elements
 * without changing the order of the remaining elements.
 * For example, [3,6,2,7] is a subsequence of the array [0,3,1,6,2,2,7]
 */
public class LongestIncreasingSubsequence {
    public int lengthOfLIS(int[] nums) {
        int l = nums.length;
        if(l==0) return 0;

        int[] dp = new int[l];
        Arrays.fill(dp, 1);

        for(int i=1; i<l;i++){
            for(int j=0; j<i; j++){
                if(nums[i] > nums[j] && dp[i] < dp[j]+1){
                    dp[i]=dp[j]+1;
                }
            }
        }
        int max = 0;
        for(int i : dp){
            if(i>max) max=i;
        }
        return max;
    }
}
