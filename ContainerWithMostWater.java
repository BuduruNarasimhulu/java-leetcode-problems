package com.leetcode.problems;

public class ContainerWithMostWater {
	public int maxArea(int[] height) {
		// Initialize two pointers, one at the beginning (left) and one at the end
		// (right) of the array
		int left = 0;
		int right = height.length - 1;
		// Variable to keep track of the maximum area found so far
		int maxArea = 0;

		// Iterate until the two pointers meet
		while (left < right) {
			// Calculate the area with the current left and right pointers
			int currentArea = Math.min(height[left], height[right]) * (right - left);
			// Update maxArea if the current area is larger
			maxArea = Math.max(maxArea, currentArea);

			// Move the pointer that points to the shorter line inward
			// This is because the area is limited by the shorter line, so we try to find a
			// taller line
			if (height[left] < height[right]) {
				left++; // Move left pointer to the right
			} else {
				right--; // Move right pointer to the left
			}
		}

		// Return the maximum area found
		return maxArea;
	}

}
