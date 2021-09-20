package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class KSum {

    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        return kSum(nums, 0, 4, target);
    }

    public List<List<Integer>>  kSum(int[] nums, int start, int k, int target){
        ArrayList<List<Integer>> res = new ArrayList<>();

        if(start == nums.length || k*nums[start] > target || k*nums[nums.length-1] < target) return res;

        if(k==2) return twoSum(nums, start, target);

        for(int i=start; i<nums.length; i++){
            if(i==start || nums[i] != nums[i-1]){
                for(List<Integer> list : kSum(nums, i+1, k-1, target-nums[i])){
                    res.add(Arrays.asList(nums[i]));
                    res.get(res.size()-1).addAll(list);
                }
            }
        }
        return res;
    }

    public List<List<Integer>> twoSum(int[] nums, int start, int target){
        int l = start;
        int r = nums.length-1;
        List<List<Integer>> curr = new ArrayList<>();
        while(l < r){
            int sum = nums[l] + nums[r];
            if(sum < target || (l > start && nums[l]==nums[l-1])) l++;
            else if(sum >  target || (r < nums.length-1 && nums[r]==nums[r+1])) r--;
            else{
                curr.add(Arrays.asList(nums[l], nums[r]));
                l++;
                r--;
            }
        }
        return curr;
    }
}
