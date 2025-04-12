package com.leetcode.valid_anagram;

import org.junit.jupiter.api.Test;

import static com.leetcode.valid_anagram.ValidAnagram.isAnagram;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ValidAnagramTest {
    @Test
    void testCase1() {
        var input1 = "anagram";
        var input2 = "nagaram";
        assertTrue(isAnagram(input1, input2));
    }

    @Test
    void testCase2() {
        var input1 = "car";
        var input2 = "rat";
        assertFalse(isAnagram(input1, input2));
    }
}
