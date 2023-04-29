package com.helper.springbootreadmehelper.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
 * Notice that the solution set must not contain duplicate triplets.
 * <p>
 * Example 1:
 * Input: nums = [-1,0,1,2,-1,-4]
 * Output: [[-1,-1,2],[-1,0,1]]
 * Explanation:
 * nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0.
 * nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0.
 * nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0.
 * The distinct triplets are [-1,0,1] and [-1,-1,2].
 * Notice that the order of the output and the order of the triplets does not matter.
 * <p>
 * Example 2:
 * Input: nums = [0,1,1]
 * Output: []
 * Explanation: The only possible triplet does not sum up to 0.
 * <p>
 * Example 3:
 * Input: nums = [0,0,0]
 * Output: [[0,0,0]]
 * Explanation: The only possible triplet sums up to 0.
 *
 * @author chris
 */
public class ThreeSum {

    // Using Two pointers and utilizing the sorted array learned from the TwoSumII
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            if (i == 0 || nums[i]!= nums[i-1]){
                int target = -nums[i];
                int lo = i + 1;
                int hi = nums.length - 1;
                while(lo < hi){
                    int sum = nums[lo] + nums[hi];
                    if (sum == target){
                        ans.add(Arrays.asList(nums[i],nums[lo++],nums[hi--]));
                        // Avoid duplicate problem:
                        // If the next number remain still, just keep moving to the next
                        while(lo < hi && nums[lo] == nums[lo-1]) {
                            lo++;
                        }
                    } else if (sum < target){
                        lo++;
                    } else {
                        hi--;
                    }
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        // output: [[-1,-1,2],[-1,0,1]]
//        int[] nums = new int[]{-1, 0, 1, 2, -1, -4};
//        int[] nums = new int[]{0, 0, 0};
//        int[] nums = new int[]{0,1,1};
        int[] nums = new int[]{-2,0,0,2,2};
        System.out.println(threeSum(nums).toString());
    }
}
