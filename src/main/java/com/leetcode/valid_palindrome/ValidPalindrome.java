package com.leetcode.valid_palindrome;

public class ValidPalindrome {
    static boolean isPalindrome(String s) {
        s = s.toLowerCase().replaceAll("[^a-z0-9]", "");

        for (int i = 0; i < s.length() / 2; i++) {
            var left = String.valueOf(s.charAt(i));
            var right = String.valueOf(s.charAt(s.length() - i - 1));
            if (!left.equals(right)) return false;
        }

        return true;
    }
}
