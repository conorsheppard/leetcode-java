package com.leetcode.island_perimeter_463;

import java.util.stream.IntStream;

public class IslandPerimeter {
    public int islandPerimeter(int[][] grid) {
        if (grid.length == 0) return 0;

        return IntStream.range(0, grid.length)
                .flatMap(row -> IntStream.range(0, grid[row].length)
                        .map(col -> countWaterPerimeter(grid, row, col)))
                .sum();
    }

    private int countWaterPerimeter(int[][] grid, int row, int col) {
        if (grid[row][col] == 0) return 0;
        var count = 0;
        count += isWater(grid, row, col - 1) ? 1 : 0; // left
        count += isWater(grid, row, col + 1) ? 1 : 0; // right
        count += isWater(grid, row - 1, col) ? 1 : 0; // up
        count += isWater(grid, row + 1, col) ? 1 : 0; // down
        return count;
    }

    private boolean isWater(int[][] grid, int row, int col) {
        return isOutOfBounds(grid, row, col) || grid[row][col] == 0;
    }

    private boolean isOutOfBounds(int[][] grid, int row, int col) {
        return row < 0 || row >= grid.length
                || col < 0 || col >= grid[row].length;
    }
}
