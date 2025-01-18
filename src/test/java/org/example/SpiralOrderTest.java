package org.example;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.example.SpiralOrder.spiralOrder;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SpiralOrderTest {

    @Test
    public void testCase1() {
        var matrix = new int[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        assertEquals(List.of(1, 2, 3, 6, 9, 8, 7, 4, 5), spiralOrder(matrix));
    }

    @Test
    public void testCase2() {
        var matrix = new int[][]{
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12}
        };

        assertEquals(List.of(1, 2, 3, 4, 8, 12, 11, 10, 9, 5, 6, 7), spiralOrder(matrix));
    }

    @Test
    public void testCase3() {
        var matrix = new int[][]{
                {1, 2, 3, 4, 5},
                {6, 7, 8, 9, 10},
                {11, 12, 13, 14, 15}
        };

        assertEquals(List.of(1, 2, 3, 4, 5, 10, 15, 14, 13, 12, 11, 6, 7, 8, 9), spiralOrder(matrix));
    }

    @Test
    public void testCase4() {
        var matrix = new int[][]{{2, 3}};

        assertEquals(List.of(2, 3), spiralOrder(matrix));
    }

    @Test
    public void testCase5() {
        var matrix = new int[][]{{3}, {2}};

        assertEquals(List.of(3, 2), spiralOrder(matrix));
    }

    @Test
    public void testCase6() {
        var matrix = new int[][]{
                {2, 5},
                {8, 4},
                {0, -1}
        };

        assertEquals(List.of(2, 5, 4, -1, 0, 8), spiralOrder(matrix));
    }

    @Test
    public void testCase7() {
        var matrix = new int[][]{
                {2, 5, 6, 3, 1, 6, 0},
                {8, 4, 5, 6, 3, 1, 6},
                {0, 5, 6, 3, 1, 6, -1},
                {8, 4, 5, 6, 3, 1, 6},
                {8, 4, 5, 6, 3, 1, 6},
                {8, 4, 5, 6, 3, 1, 6},
                {8, 4, 5, 6, 3, 1, 6}
        };

        assertEquals(List.of(2, 5, 6, 3, 1, 6, 0, 6, -1, 6, 6, 6, 6, 1, 3, 6, 5, 4, 8, 8, 8, 8, 0,
                8, 4, 5, 6, 3, 1, 6, 1, 1, 1, 3, 6, 5, 4, 4, 4,
                5, 6, 3, 1, 3, 3, 6, 5,
                5, 6), spiralOrder(matrix));
    }

    @Test
    public void testCase8() {
        var matrix = new int[][]{
                {0, 0, 0, 0, 0},
                {3, 4, 4, 4, 1},
                {3, 7, 8, 5, 1},
                {3, 6, 6, 5, 1},
                {2, 2, 2, 2, 1}
        };

        assertEquals(List.of(0, 0, 0, 0, 0, 1, 1, 1, 1, 2, 2, 2, 2, 3, 3, 3, 4, 4, 4, 5, 5, 6, 6, 7, 8), spiralOrder(matrix));
    }
}
