package com.leetcode.move_zeros_283;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class MoveZerosTest {

    private final MoveZeros moveZeros = new MoveZeros();

    @Test
    void testExampleCase() {
        int[] nums = {0, 1, 0, 3, 12};
        moveZeros.moveZeroes(nums);
        assertArrayEquals(new int[]{1, 3, 12, 0, 0}, nums);
    }

    @Test
    void testAllZeros() {
        int[] nums = {0, 0, 0, 0};
        moveZeros.moveZeroes(nums);
        assertArrayEquals(new int[]{0, 0, 0, 0}, nums);
    }

    @Test
    void testNoZeros() {
        int[] nums = {1, 2, 3, 4};
        moveZeros.moveZeroes(nums);
        assertArrayEquals(new int[]{1, 2, 3, 4}, nums);
    }

    @Test
    void testZerosAtTheEnd() {
        int[] nums = {1, 2, 3, 0, 0};
        moveZeros.moveZeroes(nums);
        assertArrayEquals(new int[]{1, 2, 3, 0, 0}, nums);
    }

    @Test
    void testZerosAtTheStart() {
        int[] nums = {0, 0, 1, 2, 3};
        moveZeros.moveZeroes(nums);
        assertArrayEquals(new int[]{1, 2, 3, 0, 0}, nums);
    }

    @Test
    void testSingleElementZero() {
        int[] nums = {0};
        moveZeros.moveZeroes(nums);
        assertArrayEquals(new int[]{0}, nums);
    }

    @Test
    void testSingleElementNonZero() {
        int[] nums = {7};
        moveZeros.moveZeroes(nums);
        assertArrayEquals(new int[]{7}, nums);
    }

    @Test
    void testEmptyArray() {
        int[] nums = {};
        moveZeros.moveZeroes(nums);
        assertArrayEquals(new int[]{}, nums);
    }

    @Test
    void testAlternatingZerosAndNonZeros() {
        int[] nums = {0, 1, 0, 2, 0, 3};
        moveZeros.moveZeroes(nums);
        assertArrayEquals(new int[]{1, 2, 3, 0, 0, 0}, nums);
    }
}
