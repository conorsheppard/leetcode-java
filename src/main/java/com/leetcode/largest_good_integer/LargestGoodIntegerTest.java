package com.leetcode.largest_good_integer;

import org.junit.jupiter.api.Test;

import static com.leetcode.largest_good_integer.LargestGoodInteger.largestGoodInteger;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class LargestGoodIntegerTest {

    @Test
    void testCase1() {
        assertEquals("777", largestGoodInteger("6777133339"));
    }

    @Test
    void testCase2() {
        assertEquals("000", largestGoodInteger("2300019"));
    }

    @Test
    void testCase3() {
        assertEquals("", largestGoodInteger("42352338"));
    }
}
