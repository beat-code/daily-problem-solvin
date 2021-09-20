package leetcode.dec_2020;

public class _15SquareOfSortedArray {


    public int[] sortedSquares(int[] nums) {
        int n=nums.length;
        int[] ans = new int[n];
        int l = 0;
        int r = n-1;
        int i = n-1;
        while(l <= r){
            if(Math.abs(nums[l]) >= Math.abs(nums[r])){
                ans[i--] = nums[l]*nums[l];
                l++;
            }else{
                ans[i--] = nums[r]*nums[r];
                r--;
            }
        }

        return ans;
    }

    public int[] sortedSquaresFIRST_ATTEMPT(int[] nums) {
        int n=nums.length;
        for(int i=0; i<n; i++){
            nums[i] = nums[i]*nums[i];
        }
        int l=1;
        int mid =-1;
        while(l<n){
            if(nums[l] > nums[l-1]){
                mid = l-1;
                break;
            }else{
                l++;
            }
        }
        int[] ans = new int[n];
        l=mid==-1?n-1 : mid-1;
        int r= l==n-1?n : mid;
        int i=0;
        while(l >= 0 && r < n){
            if(nums[l] <= nums[r]){
                ans[i] = nums[l];
                l--;
            }else{
                ans[i] = nums[r];
                r++;
            }
            i++;
        }
        while(l >= 0){
            ans[i++] = nums[l--];
        }

        while(r < n){
            ans[i++] = nums[r++];
        }
        return ans;
    }
}
