package com.leetcode.merge_sorted_array;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import org.junit.jupiter.api.Test;

public class MergeSortedArrayTest {

    @Test
    public void testCase1() {
        var nums1 = new int[]{1, 2, 3, 0, 0, 0};
        var nums2 = new int[]{2, 5, 6};
        int m = 3, n = 3;
        var expected = new int[]{1, 2, 2, 3, 5, 6};
        var result = MergeSortedArray.merge(nums1, m, nums2, n);
        assertEquals(Arrays.toString(expected), Arrays.toString(result));
    }

    @Test
    public void testCase2() {
        int[] nums1 = new int[]{1}, nums2 = new int[]{};
        int m = 1, n = 0;
        var expected = new int[]{1};
        var result = MergeSortedArray.merge(nums1, m, nums2, n);
        assertEquals(Arrays.toString(expected), Arrays.toString(result));
    }

    @Test
    public void testCase3() {
        int[] nums1 = new int[]{0}, nums2 = new int[]{1};
        int m = 0, n = 1;
        var expected = new int[]{1};
        var result = MergeSortedArray.merge(nums1, m, nums2, n);
        assertEquals(Arrays.toString(expected), Arrays.toString(result));
    }
}
