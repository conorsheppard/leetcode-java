package com.leetcode.smaller_numbers_than_current;

import org.junit.jupiter.api.Test;

import static com.leetcode.smaller_numbers_than_current.SmallerNumbersThanCurrent.smallerNumbersThanCurrent;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class SmallerNumbersThanCurrentTest {

    @Test
    public void testCase1() {
        var nums = new int[]{8, 1, 2, 2, 3};
        assertArrayEquals(new int[]{4, 0, 1, 1, 3}, smallerNumbersThanCurrent(nums));
    }

    @Test
    public void testCase2() {
        var nums = new int[]{6, 5, 4, 8};

        assertArrayEquals(new int[]{2, 1, 0, 3}, smallerNumbersThanCurrent(nums));
    }

    @Test
    public void testCase3() {
        var nums = new int[]{7, 7, 7, 7};

        assertArrayEquals(new int[]{0, 0, 0, 0}, smallerNumbersThanCurrent(nums));
    }
}
