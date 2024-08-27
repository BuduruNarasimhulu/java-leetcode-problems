package com.leetcode.problems;

public class LongestSubstringWithoutRepeatingCharacters {
	
    public int lengthOfLongestSubstring(String s) {
        // Array to store the last seen index of each character (assuming ASCII characters)
        int[] map = new int[128];
        // Variable to store the maximum length of substring without repeating characters
        int max = 0;
        // Pointer to keep track of the start of the current substring
        int j = 0;

        // Iterate through the string, using 'i' as the end pointer of the current substring
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i); // Get the current character
            
            // If the character has been seen before and is within the current window
            if (map[c] > 0) {
                // Update the start pointer 'j' to ensure no duplicates in the current substring
                j = Math.max(j, map[c]);
            }

            // Update the last seen index of the current character ('c')
            map[c] = i + 1;

            // Calculate the length of the current substring and update 'max' if it's longer
            max = Math.max(max, i - j + 1);
        }

        // Return the maximum length of substring found
        return max;

        /*
         * Alternative Approach: Sliding Window with HashSet (commented out)
         * 
         * This approach uses a HashSet to maintain the current window of unique characters.
         * 
         * HashSet<Character> hs = new HashSet<>();
         * int length = 0;
         * int j = 0;
         * for (int i = 0; i < s.length(); i++) {
         *     char ch = s.charAt(i);
         *     while (hs.contains(ch)) {
         *         hs.remove(s.charAt(j++));
         *     }
         *     hs.add(ch);
         *     length = Math.max(hs.size(), length);
         * }
         * return length;
         */
    }
}


