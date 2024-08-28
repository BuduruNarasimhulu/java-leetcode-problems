package com.leetcode.problems;

import java.util.*;

public class FourSum {

	private List<List<Integer>> result;

	/**
	 * Finds all unique quadruplets in the array which gives the sum of the target.
	 * 
	 * @param nums   The input array of integers.
	 * @param target The target sum for the quadruplets.
	 * @return A list of lists containing the quadruplets that sum up to the target.
	 */
	public List<List<Integer>> fourSum(int[] nums, int target) {
		return new AbstractList<List<Integer>>() {

			@Override
			public List<Integer> get(int index) {
				initializeResult();
				return result.get(index);
			}

			@Override
			public int size() {
				initializeResult();
				return result.size();
			}

			/**
			 * Initializes the result list by finding all quadruplets that sum to the
			 * target.
			 */
			private void initializeResult() {
				// If result is already initialized, no need to recompute
				if (result != null) {
					return;
				}

				// Initialize an empty list to store the valid quadruplets
				List<List<Integer>> quadruplets = new ArrayList<>();

				// Edge case: If the array has fewer than 4 elements, return empty result
				if (nums.length < 4) {
					result = quadruplets;
					return;
				}

				// Sort the array to facilitate the two-pointer approach
				Arrays.sort(nums);
				int n = nums.length;

				// Iterate through the array to find all quadruplets
				for (int i = 0; i < n - 3; i++) {
					// Skip duplicate elements for the first number
					if (i > 0 && nums[i] == nums[i - 1])
						continue;

					for (int j = i + 1; j < n - 2; j++) {
						// Skip duplicate elements for the second number
						if (j > i + 1 && nums[j] == nums[j - 1])
							continue;

						// Two-pointer approach to find the remaining two numbers
						int left = j + 1;
						int right = n - 1;
						long remainingSum = (long) target - nums[i] - nums[j];

						while (left < right) {
							long currentSum = nums[left] + nums[right];

							if (currentSum == remainingSum) {
								// Valid quadruplet found
								quadruplets.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));

								// Skip duplicates for the third and fourth numbers
								while (left < right && nums[left] == nums[left + 1])
									left++;
								while (left < right && nums[right] == nums[right - 1])
									right--;

								left++;
								right--;
							} else if (currentSum < remainingSum) {
								left++; // Increase the sum by moving left pointer to the right
							} else {
								right--; // Decrease the sum by moving right pointer to the left
							}
						}
					}
				}

				// Store the computed quadruplets in the result
				result = quadruplets;
			}
		};
	}
}
