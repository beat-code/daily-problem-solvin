package dp;


import java.util.Arrays;

/**
 * For example, [3,6,2,7] is a subsequence of the array [0,3,1,6,2,2,7]
 * Ans = [0+3+6+7]
 */
public class LISWithMaxSum {

    public static void main(String[] args) {
        int[] arr = {17,0,3,1,6,2,2,7};

        System.out.println(lisWithMaxSum(arr));
    }

    public static int lisWithMaxSum(int[] nums) {
        int l = nums.length;
        if(l==0) return 0;

        int[] dp = new int[l];
        for(int i=0; i<l; i++) dp[i] = nums[i];

        for(int i=1; i<l; i++){
            for(int j=0; j< i; j++){
                if(nums[i] > nums[j] && dp[i] < dp[j] + nums[i]){
                    dp[i] = dp[j] + nums[i];
                }
            }
        }

        int max=Integer.MIN_VALUE;
        for(int i : dp){
            if(max < i) max=i;
        }
        return max;
    }
}
