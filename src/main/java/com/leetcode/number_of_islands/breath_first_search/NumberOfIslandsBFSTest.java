package com.leetcode.number_of_islands.breath_first_search;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.stream.IntStream;

import static com.leetcode.number_of_islands.breath_first_search.NumberOfIslandsBFS.numIslandsBFS;

public class NumberOfIslandsBFSTest {

    @Test
    public void testCase1() {
        char[][] grid = {
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}};

        assertEquals(1, numIslandsBFS(grid));
    }

    @Test
    public void testCase2() {
        char[][] grid = {
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}};

        assertEquals(3, numIslandsBFS(grid));
    }

    @Test
    public void testCase3() {
        char[][] grid = {{'1'}};

        assertEquals(1, numIslandsBFS(grid));
    }

    @Test
    public void testCase4() {
        char[][] grid = {{'0'}};

        assertEquals(0, numIslandsBFS(grid));
    }

    @Test
    public void testCase5() {
        char[][] grid = {{'1', '0', '1',}};

        assertEquals(2, numIslandsBFS(grid));
    }

    @Test
    public void testCase6() {
        char[][] grid = {{'0', '1', '0',}};

        assertEquals(1, numIslandsBFS(grid));
    }

    @Test
    public void testCase7() {
        char[][] grid = {
                {'0', '0', '0', '0', '0'},
                {'0', '0', '0', '0', '0'},
                {'0', '0', '0', '0', '0'},
                {'0', '0', '0', '0', '1'}};

        assertEquals(1, numIslandsBFS(grid));
    }

    @Test
    public void testCase8() {
        char[][] grid = {
                {'1', '1', '1'},
                {'0', '1', '0'},
                {'1', '1', '1'}
        };
        assertEquals(1, numIslandsBFS(grid));
    }

    @Test
    public void testCase9() {
        char[][] grid = {
                {'1', '1'},
                {'1', '0'},
        };
        assertEquals(1, numIslandsBFS(grid));
    }

    @Test
    public void testCase10() {
        char[][] grid = {
                {'1', '1', '1'},
                {'1', '0', '0'},
                {'1', '0', '0'},
        };
        assertEquals(1, numIslandsBFS(grid));
    }

    @Test
    public void testCase11() {
        char[][] grid = {
                {'1', '0', '0'},
                {'1', '0', '0'},
                {'1', '0', '0'},
                {'1', '0', '0'},
                {'1', '0', '0'},
                {'1', '0', '0'},
                {'1', '0', '0'},
                {'1', '0', '0'}
        };
        assertEquals(1, numIslandsBFS(grid));
    }

    @Test
    public void testCase12() {
        char[][] grid = IntStream.range(0, 10)
                .mapToObj(_ -> {
                    char[] row = new char[10];
                    Arrays.fill(row, '1');
                    return row;
                }).toArray(char[][]::new);

        assertEquals(1, numIslandsBFS(grid));
    }
}
