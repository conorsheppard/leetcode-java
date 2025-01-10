package org.example;

import org.junit.jupiter.api.Test;

import static org.example.FinalValueAfterOperations.finalValueAfterOperations;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class FinalValueAfterOperationsTest {

    @Test
    public void testCase1() {
        var operations = new String[]{"--X", "X++", "X++"};
        assertEquals(finalValueAfterOperations(operations), 1);
    }

    @Test
    public void testCase2() {
        var operations = new String[]{"++X", "++X", "X++"};
        assertEquals(finalValueAfterOperations(operations), 3);
    }

    @Test
    public void testCase3() {
        var operations = new String[]{"X++", "++X", "--X", "X--"};
        assertEquals(finalValueAfterOperations(operations), 0);
    }
}
