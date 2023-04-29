package com.helper.springbootreadmehelper.array;

import java.util.Arrays;

/**
 * Given a 1-indexed array of integers numbers that is already sorted in non-decreasing order, find two numbers such that they add up to a specific target number. Let these two numbers be numbers[index1] and numbers[index2] where 1 <= index1 < index2 <= numbers.length.
 *
 * Return the indices of the two numbers, index1 and index2, added by one as an integer array [index1, index2] of length 2.
 * The tests are generated such that there is exactly one solution. You may not use the same element twice.
 * Your solution must use only constant extra space.
 *
 * Example 1:
 *
 * Input: numbers = [2,7,11,15], target = 9
 * Output: [1,2]
 * Explanation: The sum of 2 and 7 is 9. Therefore, index1 = 1, index2 = 2. We return [1, 2].
 * Example 2:
 *
 * Input: numbers = [2,3,4], target = 6
 * Output: [1,3]
 * Explanation: The sum of 2 and 4 is 6. Therefore index1 = 1, index2 = 3. We return [1, 3].
 * Example 3:
 *
 * Input: numbers = [-1,0], target = -1
 * Output: [1,2]
 * Explanation: The sum of -1 and 0 is -1. Therefore index1 = 1, index2 = 2. We return [1, 2].
 *
 * @author chris
 */
public class TwoSumII {

    public static int[] twoSum(int[] numbers, int target) {
        int lo = 0;
        int hi = numbers.length-1;
        while(lo <= hi){
            int sum = numbers[lo]+ numbers[hi];
            if (sum == target){
                break;
            } else if (sum > target) {
                hi--;
            } else {
                lo++;
            }
        }
        return new int[]{++lo,++hi};
    }

    public static void main(String[] args){
        int[] nums1 = new int[]{2,7,11,15};
        int[] nums2 = new int[]{2,3,4};
        int[] nums3 = new int[]{-1,0};
        int target1 = 9;
        int target2 = 6;
        int target3 = -1;
        System.out.println(Arrays.toString(twoSum(nums1,target1)));
    }
}
