package com.helper.springbootreadmehelper.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given an array nums of n integers, return an array of all the unique quadruplets [nums[a], nums[b], nums[c], nums[d]] such that:
 *
 * 1. 0 <= a, b, c, d < n
 * 2. a, b, c, and d are distinct.
 * 3. nums[a] + nums[b] + nums[c] + nums[d] == target
 * You may return the answer in any order.
 *
 *  Example 1:
 * Input: nums = [1,0,-1,0,-2,2], target = 0
 * Output: [[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
 *
 * Example 2:
 * Input: nums = [2,2,2,2,2], target = 8
 * Output: [[2,2,2,2]]
 * @author chris
 */
public class FourSum {

    public static List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        return kSum(nums,target,0,4);
    }

    public static List<List<Integer>> kSum(int[] nums, long target, int start, int k) {
        List<List<Integer>> res = new ArrayList<>();

        //1. start已達數列末項
        if (start == nums.length){
            return res;
        }
        //2. 檢查Two pointers兩數nums[lo]、nums[nums.length-1]是否大於或小於平均數
        long average = target/k;
        if (nums[start] > average || nums[nums.length-1] < average){
            return res;
        }
        //3. 終止條件(進入twoSum找解)
        if (k==2){
            return twoSum(nums,target,start);
        }

        //遞迴關係
        //[-3,-2,-1,0,0,1,2,3]
        for (int i = start;i<nums.length;i++){
            //當前項若等於前項則跳下一項
            if(i==start || nums[i]!=nums[i-1]){
                List<List<Integer>> twoSumRes = kSum(nums,target-nums[i],i+1,k-1);
                if (twoSumRes.size()!=0){
                    for (List<Integer> sub : twoSumRes){
                        //每一個sub都再創一個新的當前項，然後加到sub內
                        res.add(new ArrayList<>(Arrays.asList(nums[i])));
                        res.get(res.size()-1).addAll(sub);
                    }
                }
            }
        }
        return res;
    }

    // Two pointers (Ref: TwoSumII)
    public static List<List<Integer>> twoSum(int[] nums, long target, int start) {
        List<List<Integer>> res = new ArrayList<>();
        int lo = start;
        int hi = nums.length-1;
        while(lo < hi){
            int sum = nums[lo] + nums[hi];
            if (sum > target || (hi < nums.length-1 && nums[hi] == nums[hi+1])){
                --hi;
            } else if (sum < target || (lo > start && nums[lo] == nums[lo-1])){
                ++lo;
            } else {
                res.add(Arrays.asList(nums[lo++],nums[hi--]));
            }
        }
        return res;
    }


    public static void main(String[] args) {
        int[] nums = new int[]{-3,-2,-1,0,0,1,2,3};
        int target = 0;
        //Expected: [[-3,-2,2,3],[-3,-1,1,3],[-3,0,0,3],[-3,0,1,2],[-2,-1,0,3],[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
        System.out.println(fourSum(nums,target));
    }

}
