package com.leetcode.problems;

public class LongestPalindromicSubstring {
	 // Variables to store the starting and ending indices of the longest palindromic substring
    public int start = 0;
    public int end = 0;

    // Helper function to find the longest palindrome centered at index 'i'
    private void palindrome(char[] ch, int i) {
        int l = i; // Left pointer
        int r = i; // Right pointer
        int n = ch.length; // Length of the character array

        // Base case: If the index 'i' is at the last character, return
        if (i >= n - 1) return;

        // Extend the right pointer to the right as long as the characters are the same (for even-length palindromes)
        while (r < n - 1 && ch[r] == ch[r + 1]) r++;
        i = r; // Update the current index to the new right pointer position

        // Expand around the center as long as the characters on both sides match
        while (l > 0 && r < n - 1 && ch[l - 1] == ch[r + 1]) {
            l--;
            r++;
        }

        // Update the start and end indices if a longer palindrome is found
        if ((end - start) < (r - l)) {
            end = r;
            start = l;
        }

        // Recursively check for the next possible center
        palindrome(ch, i + 1);
    }

    // Main function to find the longest palindromic substring
    public String longestPalindrome(String s) {
        char[] ch = s.toCharArray(); // Convert the input string to a character array
        palindrome(ch, 0); // Start finding the palindrome from the first character
        return s.substring(start, end + 1); // Return the longest palindromic substring
    }
}


