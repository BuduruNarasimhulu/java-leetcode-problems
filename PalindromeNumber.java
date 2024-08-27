package com.leetcode.problems;

public class PalindromeNumber {
	public boolean isPalindrome(int x) {
        // Edge case: Negative numbers and numbers ending with 0 (but not 0 itself) cannot be palindromes
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }

        // Variable to store the reversed number
        int reverse = 0;
        // Store the original number for later comparison
        int original = x;

        // Loop to reverse the digits of the number
        while (x > 0) {
            // Extract the last digit and add it to the reversed number
            reverse = x % 10 + reverse * 10;
            // Remove the last digit from x
            x = x / 10;
        }

        // Compare the original number with the reversed number
        // If they are equal, then the number is a palindrome
        return original == reverse;
    }

}
