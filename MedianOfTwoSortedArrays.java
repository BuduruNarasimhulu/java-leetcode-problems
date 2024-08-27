package com.leetcode.problems;

import java.util.*;

public class MedianOfTwoSortedArrays {
	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // Get the lengths of the input arrays
        int firstArrayLength = nums1.length;
        int secondArrayLength = nums2.length;

        // Create an array to hold the merged elements from both arrays
        int mergedArray[] = new int[firstArrayLength + secondArrayLength];

        // Index to track the position in the merged array
        int index = 0;

        // Copy elements from the first array into the merged array
        for (int i : nums1) {
            mergedArray[index++] = i;
        }

        // Copy elements from the second array into the merged array
        for (int i : nums2) {
            mergedArray[index++] = i;
        }

        // Sort the merged array to prepare for median calculation
        Arrays.sort(mergedArray);

        // Determine the length of the merged array
        int n = mergedArray.length;

        // If the merged array has an odd length, return the middle element as the median
        if (n % 2 != 0) {
            return mergedArray[n / 2];
        } else {
            // If the merged array has an even length, return the average of the two middle elements
            return (mergedArray[n / 2 - 1] + mergedArray[n / 2]) / 2.0;
        }
    }

}
