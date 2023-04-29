package com.helper.springbootreadmehelper.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 * You can return the answer in any order.
 * <p>
 * Example 1:
 * Input: nums = [2,7,11,15], target = 9
 * Output: [0,1]
 * Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
 * <p>
 * Example 2:
 * Input: nums = [3,2,4], target = 6
 * Output: [1,2]
 * <p>
 * Example 3:
 * Input: nums = [3,3], target = 6
 * Output: [0,1]
 * @author chris
 */
public class TwoSum {

    /**
     * Brute Force
     */
    public static int[] twoSum(int[] nums, int target) {
        int[] ans = new int[2];
        for (int i = 0; i <= nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int first = nums[i];
                int second = nums[j];
                int sum = first + second;
                if (sum == target){
                    ans[0] = i;
                    ans[1] = j;
                }
            }
        }
        return ans;
    }

    /**
     * Using HashMap
     * */
    public static int[] twoSumMap(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<>(nums.length);
        int[] ans = new int[2];
        for (int i = 0; i < nums.length; i++){
            int tempNum = target - nums[i];
            if (map.containsKey(tempNum)){
                ans[0] = map.get(tempNum);
                ans[1] = i;
                return ans;
            }
            map.put(nums[i],i);
        }
        return null;
    }

    public static void main(String[] args) {
//        int[] nums = {2, 7, 11, 15};
        int[] nums = {3,2,4};
//        int[] nums = {3,3};
//        int target = 9;
        int target = 6;
//        int target = 6;
        System.out.println(Arrays.toString(twoSumMap(nums, target)));
        System.out.println();
    }

}
