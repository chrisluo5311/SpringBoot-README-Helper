package com.helper.springbootreadmehelper.array;

/**
 * @author chris
 */
public class RemoveDuplicatesFromSortedArray {


    public static int removeDuplicates(int[] nums) {
        int insertIndex = 1;
        for (int i = 1; i<nums.length;++i){
            if (nums[i] != nums[i-1]){
                nums[insertIndex] = nums[i];
                insertIndex++;
            }
        }
        return insertIndex;
    }

    public static void main(String[] args) {
        
    }


}
