package com.leetcode.number_of_islands.breath_first_search;

import java.util.LinkedList;
import java.util.Queue;

public class NumberOfIslandsBFS {
    public static int numIslandsBFS(char[][] grid) {
        if (grid == null || grid.length == 0) return 0; // edge cases

        int numIslands = 0;
        int rows = grid.length, cols = grid[0].length;
        // Right, Down, Left, Up
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

        for (int currentRowIndex = 0; currentRowIndex < rows; currentRowIndex++) { // iterates over the rows
            for (int currentColumnIndex = 0; currentColumnIndex < cols; currentColumnIndex++) { // iterates over the columns
                if (grid[currentRowIndex][currentColumnIndex] == '1') { // checks for a piece of land
                    // BFS commences and the island counter is incremented
                    numIslands++;
                    // Instantiate a new queue to store the coordinates of the land as we pass over the grid,
                    // a queue is used because it is FIFO
                    Queue<int[]> landQueue = new LinkedList<>();
                    // queue.offer() adds an element to the queue
                    landQueue.offer(new int[]{currentRowIndex, currentColumnIndex});
                    // Mark as visited so that we don't count it again when we come back
                    grid[currentRowIndex][currentColumnIndex] = '0';

                    // While the queue has elements remaining, we are going to iterate over them and explore the adjacent cells
                    while (!landQueue.isEmpty()) {
                        // Remove the element atop the queue,
                        // this will be the element least recently added to the queue as queues are FIFO
                        int[] currentCell = landQueue.poll();
                        // row: a row index
                        int currentRow = currentCell[0];
                        // column: a column index
                        int currentColumn = currentCell[1];

                        // for loop to iterate over all the adjacent cells,
                        // first we look right, then down, left and then up
                        for (int[] dir : directions) {
                            // Save the adjacent cell coordinates in two new variables,
                            // if this cell passes the bounds checks below, we'll check it for land (a '1' char)
                            int adjacentRow = currentRow + dir[0], adjacentColumn = currentColumn + dir[1];

                            if (adjacentRow >= 0 // upward-direction lower-bounds check, e.g. when we look at cell {0, 0},
                                    // the adjacentRow index value would be equal to -1, which would send us out of bounds
                                    && adjacentRow < rows // downward-direction upper-bounds check, we need to make sure the index
                                    // value of the row is less than the number of rows in the grid (grid.length)
                                    && adjacentColumn >= 0 // left-hand-side lower-bounds check
                                    && adjacentColumn < cols // right-hand-side upper-bounds check
                                    && grid[adjacentRow][adjacentColumn] == '1' // finally, if all bounds checks pass we index into
                                    // the grid and check if we've hit land
                            ) {
                                // If we have hit land, we add the coordinate to the queue
                                landQueue.offer(new int[]{adjacentRow, adjacentColumn});
                                grid[adjacentRow][adjacentColumn] = '0'; // Mark as visited
                            }
                        }
                    }
                }
            }
        }
        return numIslands;
    }
}