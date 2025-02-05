package org.example;

import org.junit.jupiter.api.Test;

import static org.example.MaximumAverageSubarray1.findMaxAverage;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MaximumAverageSubarray1Test {
    @Test
    public void testCase1() {
        int[] nums = {1, 12, -5, -6, 50, 3}; // a: 2, b: 51, c: 42
        double expected = 12.75;
        assertEquals(expected, findMaxAverage(nums, 4));
    }

    @Test
    public void testCase2() {
        int[] nums = {5, 6, 7, 8, 9};
        double expected = 7.0;
        assertEquals(expected, findMaxAverage(nums, 5));
    }

    @Test
    public void testCase3() {
        int[] nums = {5};
        double expected = 5.0;
        assertEquals(expected, findMaxAverage(nums, 1));
    }

    @Test
    public void testCase4() {
        int[] nums = {0, 1, 1, 3, 3};
        double expected = 2.0;
        assertEquals(expected, findMaxAverage(nums, 4));
    }

    @Test
    public void testCase5() {
        int[] nums = {8860, -853, 6534, 4477, -4589, 8646, -6155, -5577, -1656, -5779, -2619, -8604, -1358, -8009, 4983, 7063, 3104, -1560, 4080, 2763, 5616, -2375, 2848, 1394, -7173, -5225, -8244, -809, 8025, -4072, -4391, -9579, 1407, 6700, 2421, -6685, 5481, -1732, -8892, -6645, 3077, 3287, -4149, 8701, -4393, -9070, -1777, 2237, -3253, -506, -4931, -7366, -8132, 5406, -6300, -275, -1908, 67, 3569, 1433, -7262, -437, 8303, 4498, -379, 3054, -6285, 4203, 6908, 4433, 3077, 2288, 9733, -8067, 3007, 9725, 9669, 1362, -2561, -4225, 5442, -9006, -429, 160, -9234, -4444, 3586, -5711, -9506, -79, -4418, -4348, -5891};
        double expected = -594.58065;
        assertEquals(expected, findMaxAverage(nums, 93));
    }

    @Test
    public void testCase6() {
        int[] nums = {5, 13};
        double expected = 9.0;
        assertEquals(expected, findMaxAverage(nums, 2));
    }
}
