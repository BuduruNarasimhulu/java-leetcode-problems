package com.leetcode.problems;

public class ReverseInteger {
    public int reverse(int x) {
        // Initialize variables to store the reversed number and the current digit
        int reverse = 0;
        int remainder = 0;

        // Loop through each digit of the number until x becomes 0
        while (x != 0) {   
            // Extract the last digit (remainder) of the number
            remainder = x % 10;
            // Remove the last digit from x
            x = x / 10;
            
            // Check if the reverse will overflow after multiplication
            // Integer.MAX_VALUE is 2147483647
            // If reverse > Integer.MAX_VALUE / 10, multiplying by 10 would overflow
            // If reverse == Integer.MAX_VALUE / 10, adding any number greater than 7 would overflow
            if (reverse > Integer.MAX_VALUE / 10 || (reverse == Integer.MAX_VALUE / 10 && remainder > 7)) {
                return 0; // Return 0 if overflow would occur
            }

            // Check if the reverse will underflow after multiplication
            // Integer.MIN_VALUE is -2147483648
            // If reverse < Integer.MIN_VALUE / 10, multiplying by 10 would underflow
            // If reverse == Integer.MIN_VALUE / 10, adding any number less than -8 would underflow
            if (reverse < Integer.MIN_VALUE / 10 || (reverse == Integer.MIN_VALUE / 10 && remainder < -8)) {
                return 0; // Return 0 if underflow would occur
            }

            // Update the reverse by shifting the digits to the left (multiply by 10) 
            // and adding the current digit (remainder)
            reverse = reverse * 10 + remainder;
        }

        // Return the reversed number
        return reverse;
    }
}


