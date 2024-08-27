package com.leetcode.problems;

public class RegularExpressionMatching {
	public boolean isMatch(String s, String p) {
		// Create a 2D boolean matrix to store matching results
		// mat[i][j] will be true if the first i characters in s match the first j
		// characters in p
		boolean[][] mat = new boolean[s.length() + 1][p.length() + 1];

		// Empty string matches with empty pattern
		mat[0][0] = true;

		// Handle patterns like "a*", "a*b*", ".*" that can match with an empty string
		for (int j = 1; j < mat[0].length; j++) {
			if (p.charAt(j - 1) == '*') {
				// A '*' character matches zero occurrences of the character before it
				mat[0][j] = mat[0][j - 2];
			}
		}

		// Fill the matrix using dynamic programming
		for (int i = 1; i < mat.length; i++) {
			for (int j = 1; j < mat[0].length; j++) {
				// If the current characters in both strings match or the pattern has a '.'
				if (p.charAt(j - 1) == '.' || p.charAt(j - 1) == s.charAt(i - 1)) {
					// The result is the same as the result for the previous characters
					mat[i][j] = mat[i - 1][j - 1];
				}
				// If the pattern contains a '*', it could match zero or more of the preceding
				// element
				else if (p.charAt(j - 1) == '*') {
					// '*' matches zero occurrences of the preceding element
					mat[i][j] = mat[i][j - 2];

					// If the preceding element in the pattern matches the current character in the
					// string
					// or if the preceding element is '.', check if we can match more occurrences
					if (p.charAt(j - 2) == '.' || p.charAt(j - 2) == s.charAt(i - 1)) {
						// '*' matches one or more occurrences of the preceding element
						mat[i][j] = mat[i][j] || mat[i - 1][j];
					}
				}
				// If the current characters do not match, set the matrix value to false
				else {
					mat[i][j] = false;
				}
			}
		}

		// The result is stored in the bottom-right corner of the matrix
		return mat[s.length()][p.length()];
	}

}
