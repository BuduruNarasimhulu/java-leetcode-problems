package com.leetcode.problems;

public class IntegerToRoman {
	public String intToRoman(int num) {
		// Arrays holding the integer values and their corresponding Roman numerals
		int[] integerNumbers = { 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };
		String[] RomanNumbers = { "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I" };

		// StringBuilder to construct the Roman numeral string
		StringBuilder stringBuilder = new StringBuilder();

		// Loop through each value in the integerNumbers array
		for (int index = 0; index < integerNumbers.length; index++) {
			// While num is greater than or equal to the current integer value
			while (num >= integerNumbers[index]) {
				// Subtract the integer value from num
				num -= integerNumbers[index];
				// Append the corresponding Roman numeral to the StringBuilder
				stringBuilder.append(RomanNumbers[index]);
			}
		}

		// Convert the StringBuilder to a String and return it
		return stringBuilder.toString();
	}

}
