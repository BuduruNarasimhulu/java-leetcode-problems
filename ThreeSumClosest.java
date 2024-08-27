package com.leetcode.problems;

import java.util.*;

public class ThreeSumClosest {
	// This method finds the sum of three integers in the array `nums`
	// that is closest to the given `target`.
	public int threeSumClosest(int[] nums, int target) {

		// Step 1: Sort the array to make it easier to use the two-pointer technique.
		Arrays.sort(nums);

		// Step 2: Initialize `closeSum` to the sum of the first three elements.
		// This is a starting point for comparison.
		int closeSum = nums[0] + nums[1] + nums[2];

		// Step 3: Iterate through the array, using `i` as the first element of the
		// triplet.
		// We stop at `nums.length - 2` because we need at least two more elements after
		// `i`.
		for (int i = 0; i < nums.length - 2; i++) {

			// Step 4: Set two pointers, `j` just after `i` and `k` at the end of the array.
			int j = i + 1;
			int k = nums.length - 1;

			// Step 5: Use a while loop to move the two pointers towards each other,
			// checking different triplet sums.
			while (j < k) {

				// Step 6: Calculate the sum of the current triplet `nums[i]`, `nums[j]`, and
				// `nums[k]`.
				int sum = nums[i] + nums[j] + nums[k];

				// Step 7: If this sum is closer to the target than the previous closest sum,
				// update `closeSum` to this new sum.
				if (Math.abs(target - sum) < Math.abs(target - closeSum)) {
					closeSum = sum;
				}

				// Step 8: If the current sum is less than the target, move the `j` pointer to
				// the right
				// to try and increase the sum.
				if (sum < target) {
					j++;
				}
				// Step 9: If the current sum is greater than or equal to the target,
				// move the `k` pointer to the left to try and decrease the sum.
				else {
					k--;
				}
			}
		}

		// Step 10: After checking all possible triplets, return the closest sum found.
		return closeSum;
	}

}
