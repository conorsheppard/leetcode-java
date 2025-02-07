package com.leetcode.final_value_after_operations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import static com.leetcode.final_value_after_operations.FinalValueAfterOperations.finalValueAfterOperations;

public class FinalValueAfterOperationsTest {

    @Test
    public void testCase1() {
        var operations = new String[]{"--X", "X++", "X++"};
        assertEquals(finalValueAfterOperations(operations), 1);
    }

    @Test
    public void testCase2() {
        var operations = new String[]{"++X", "++X", "X++"};
        assertEquals(3, finalValueAfterOperations(operations));
    }

    @Test
    public void testCase3() {
        var operations = new String[]{"X++", "++X", "--X", "X--"};
        assertEquals(0, finalValueAfterOperations(operations));
    }
}
