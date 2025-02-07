package com.leetcode.contains_duplicates;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ContainsDuplicatesTest {

    @Test
    public void testCase1() {
        int[] nums = {1, 2, 3, 1};
        assertTrue(ContainsDuplicates.containsDuplicates(nums));
    }

    @Test
    public void testCase2() {
        int[] nums = {1, 2, 3, 4};
        assertFalse(ContainsDuplicates.containsDuplicates(nums));
    }

    @Test
    public void testCase3() {
        int[] nums = {1, 1, 1, 3, 3, 4, 3, 2, 4, 2};
        assertTrue(ContainsDuplicates.containsDuplicates(nums));
    }
}
