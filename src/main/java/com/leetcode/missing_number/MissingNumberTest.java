package com.leetcode.missing_number;

import org.junit.jupiter.api.Test;

import static com.leetcode.missing_number.MissingNumber.missingNumber;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MissingNumberTest {

    @Test
    public void testCase1() {
        int[] nums = {0, 1};
        assertEquals(2, missingNumber(nums));
    }

    @Test
    public void testCase2() {
        int[] nums = {3, 0, 1};
        assertEquals(2, missingNumber(nums));
    }

    @Test
    public void testCase3() {
        int[] nums = {9, 6, 4, 2, 3, 5, 7, 0, 1};
        assertEquals(8, missingNumber(nums));
    }

    @Test
    public void testCase4() {
        int[] nums = {0};
        assertEquals(1, missingNumber(nums));
    }
}
