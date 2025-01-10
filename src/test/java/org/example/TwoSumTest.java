package org.example;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.example.TwoSum.twoSum;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TwoSumTest {

    @Test
    public void testCase1() {
        int[] nums = {2, 7, 11, 15};
        var target = 9;

        assertEquals(Arrays.stream(twoSum(nums, target)).boxed().toList(), Arrays.asList(0, 1));
    }

    @Test
    public void testCase2() {
        int[] nums = {3, 2, 4};
        var target = 6;

        assertEquals(Arrays.stream(twoSum(nums, target)).boxed().toList(), Arrays.asList(1, 2));
    }

    @Test
    public void testCase3() {
        int[] nums = {3, 3};
        var target = 6;

        assertEquals(Arrays.stream(twoSum(nums, target)).boxed().toList(), Arrays.asList(0, 1));
    }
}
