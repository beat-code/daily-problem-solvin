package leetcode.dec_2020;

import java.util.Arrays;

public class _23NextGreaterElementIII {
    public int nextGreaterElement(int n) {
        //find first decreasing point from right

        char[] num = String.valueOf(n).toCharArray();
        int i=num.length-1;
        for(; i > 0; i--){
            if(num[i-1] < num[i]) break;
        }
        if(i==0) return -1;
        //take the small number n & find the first number > than n fromm right
        int j=num.length-1;
        for(; j>i-1; j--){
            if(num[j] > num[i-1]) break;
        }
        //swap these 2 numbers
        char temp = num[i-1];
        num[i-1] = num[j];
        num[j] = temp;
        //sort the numbers from this position till end
        Arrays.sort(num, i, num.length);
        long ans = Long.parseLong(String.valueOf(num));
        return ans > Integer.MAX_VALUE?-1:(int)ans;
    }
}
