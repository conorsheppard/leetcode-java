package com.leetcode.two_sum;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static com.leetcode.two_sum.TwoSum.twoSum;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TwoSumTest {

    @Test
    public void testCase1() {
        int[] nums = {2, 7, 11, 15};
        var target = 9;

        assertArrayEquals(new int[]{0, 1}, twoSum(nums, target));
    }

    @Test
    public void testCase2() {
        int[] nums = {3, 2, 4};
        var target = 6;

        assertArrayEquals(new int[]{1, 2}, twoSum(nums, target));
    }

    @Test
    public void testCase3() {
        int[] nums = {3, 3};
        var target = 6;

        assertArrayEquals(new int[]{0, 1}, twoSum(nums, target));
    }
}
