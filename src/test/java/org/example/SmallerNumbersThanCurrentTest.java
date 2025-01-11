package org.example;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.example.SmallerNumbersThanCurrent.smallerNumbersThanCurrent;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SmallerNumbersThanCurrentTest {

    @Test
    public void testCase1() {
        var nums = new int[]{8, 1, 2, 2, 3};
        assertTrue(Arrays.equals(smallerNumbersThanCurrent(nums), new int[]{4, 0, 1, 1, 3}));
    }

    @Test
    public void testCase2() {
        var nums = new int[]{6, 5, 4, 8};

        assertTrue(Arrays.equals(smallerNumbersThanCurrent(nums), new int[]{2, 1, 0, 3}));
    }

    @Test
    public void testCase3() {
        var nums = new int[]{7, 7, 7, 7};

        assertTrue(Arrays.equals(smallerNumbersThanCurrent(nums), new int[]{0, 0, 0, 0}));
    }
}
