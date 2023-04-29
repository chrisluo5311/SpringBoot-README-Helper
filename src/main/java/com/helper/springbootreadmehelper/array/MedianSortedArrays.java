package com.helper.springbootreadmehelper.array;

/**
 * Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.
 * The overall run time complexity should be O(log (m+n)).
 * Example 1:
 * Input: nums1 = [1,3], nums2 = [2]
 * Output: 2.00000
 * Explanation: merged array = [1,2,3] and median is 2.
 *
 * Example 2:
 * Input: nums1 = [1,2], nums2 = [3,4]
 * Output: 2.50000
 * Explanation: merged array = [1,2,3,4] and median is (2 + 3) / 2 = 2.5.
 *
 * @author chris
 * */
public class MedianSortedArrays {

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums2.length<nums1.length) {
            return findMedianSortedArrays(nums2,nums1);
        }
        int nums1Len = nums1.length;
        int nums2Len = nums2.length;
        int lo = 0;
        int hi = nums1Len;
        double median = 0;
        while(lo <= hi){
            //Get the middle point index
            int partX = (lo+hi)/2;
            int partY = (nums1Len+nums2Len+1)/2 - partX;

            //Get the left and right value of middle point
            //nums1
            int maxLeftX = (partX == 0)? Integer.MIN_VALUE:nums1[partX-1];
            int minRightX = (partX == nums1Len)? Integer.MAX_VALUE:nums1[partX];
            //nums2
            int maxLeftY = (partY == 0)? Integer.MIN_VALUE:nums2[partY-1];
            int minRightY = (partY == nums2Len)? Integer.MAX_VALUE:nums2[partY];

            //Compare the right and left value of nums1 and nums2
            if (maxLeftX <= minRightY && maxLeftY <= minRightX){
                //Check the combined length of nums1 and nums2
                if ((nums1Len+nums2Len)%2 == 0){
                    //even: (Max(X Max value,Y Max value) + Min(X Min Value,Y Min Value))/2
                    return median = (Math.max(maxLeftX,maxLeftY)+Math.min(minRightX,minRightY))/2.0;
                } else{
                    //odd: Max(Max Left X,Max Left Y)
                    return median = Math.max(maxLeftX,maxLeftY);
                }
            } else if (maxLeftX < minRightY) {
                // lo index goes to the middle point's right => middle + 1
                lo = partX + 1;
            } else {
                // hi index goes to the middle point's left => middle -1
                hi = partX - 1;
            }
        }
        return median;
    }


    public static void main(String[] args){
        int[] nums1 = new int[]{1,3};
        int[] nums2 = new int[]{2};
        System.out.println(findMedianSortedArrays(nums1,nums2));
    }

}
