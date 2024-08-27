package com.leetcode.problems;

import java.util.*;

public class RomanToInteger {
	public int romanToInt(String s) {
		// Handle edge cases: if the input string is null or empty, return 0
		if (s == null || s.length() == 0) {
			return 0;
		}

		// Map to store the Roman numerals and their corresponding integer values
		Map<Character, Integer> romanMap = new HashMap<>();
		romanMap.put('I', 1);
		romanMap.put('V', 5);
		romanMap.put('X', 10);
		romanMap.put('L', 50);
		romanMap.put('C', 100);
		romanMap.put('D', 500);
		romanMap.put('M', 1000);

		// Variable to store the final result
		int result = 0;
		// Length of the input string
		int n = s.length();

		// Loop through each character in the string
		for (int i = 0; i < n; i++) {
			// Get the integer value corresponding to the current Roman numeral
			int currentVal = romanMap.get(s.charAt(i));

			// If the current character is not the last one, compare it with the next
			// character
			if (i < n - 1) {
				// Get the integer value of the next Roman numeral
				int nextVal = romanMap.get(s.charAt(i + 1));

				// If the current value is less than the next value, subtract it from the result
				// This handles cases like IV (4) and IX (9)
				if (currentVal < nextVal) {
					result -= currentVal;
				}
				// Otherwise, add the current value to the result
				else {
					result += currentVal;
				}
			}
			// If the current character is the last one, simply add its value to the result
			else {
				result += currentVal;
			}
		}

		// Return the final result, which is the integer representation of the Roman
		// numeral
		return result;
	}

}
