package com.helper.springbootreadmehelper.array;

import java.util.Arrays;

/**
 * Given an integer array nums of length n and an integer target, find three integers in nums such that the sum is closest to target.
 * Return the sum of the three integers.
 * You may assume that each input would have exactly one solution.
 *
 * Example 1:
 * Input: nums = [-1,2,1,-4], target = 1
 * Output: 2
 * Explanation: The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 *
 * Example 2:
 * Input: nums = [0,0,0], target = 1
 * Output: 0
 * Explanation: The sum that is closest to the target is 0. (0 + 0 + 0 = 0).
 *
 * @author chris
 */
public class ThreeSumClosest {

    // [-1,2,1,-4], 1
    // -4,-1,1,2
    public static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int diff = Integer.MAX_VALUE;
        int ans = 0;
        for (int i = 0; i < nums.length-2 ; i++){
            int lo = i + 1;
            int hi = nums.length-1;
            while (lo<hi){
                int currentSum = nums[i] + nums[lo] + nums[hi];
                if (currentSum > target){
                    hi--;
                } else {
                    lo++;
                }
                if (Math.abs(currentSum - target) < diff){
                    diff = Math.abs(currentSum - target);
                    ans = currentSum;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args){
//        int[] nums = new int[]{-1,2,1,-4};
//        int[] nums = new int[]{-2,0,1,3};
        int[] nums = new int[]{1,0,1};
//        int target = 1;
        int target = 2;
        System.out.println(threeSumClosest(nums,target));
    }

}
