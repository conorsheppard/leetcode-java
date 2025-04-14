package com.leetcode.valid_palindrome;

import org.junit.jupiter.api.Test;

import static com.leetcode.valid_palindrome.ValidPalindrome.isPalindrome;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ValidPalindromeTest {

    @Test
    void testCase1() {
        assertTrue(isPalindrome("A man, a plan, a canal: Panama"));
    }

    @Test
    void testCase2() {
        assertFalse(isPalindrome("race a car"));
    }

    @Test
    void testCase3() {
        assertTrue(isPalindrome(" "));
    }

    @Test
    void testCase4() {
        assertFalse(isPalindrome("0P"));
    }
}
