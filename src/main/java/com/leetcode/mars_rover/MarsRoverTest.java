package com.leetcode.mars_rover;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Stream;

import static com.leetcode.mars_rover.Direction.*;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MarsRoverTest {

    @ParameterizedTest(name = "MarsRover #{index}")
    @MethodSource("testCases")
    @DisplayName("Mars Rover Tests")
    void marsMarsRoverTests(String commands, MarsRover input, MarsRover expected) {
        input.executeCommands(commands);
        assertEquals(expected, input, "Expected: " + expected + ", Updated MarsRover: " + input);
    }

    // L: turn left, R: turn right, M: move forward
    static Stream<Arguments> testCases() {
        return Stream.of(
                Arguments.of("R", new MarsRover(new int[]{0, 0}, N, new Plateau(5, 5)),
                        new MarsRover(new int[]{0, 0}, E, new Plateau(5, 5))),

                Arguments.of("LMLMLMLMM", new MarsRover(new int[]{1, 2}, N, new Plateau(5, 5)),
                        new MarsRover(new int[]{1, 3}, N, new Plateau(5, 5)))
        );
    }

    @Test
    void testBasicMovement() {
        Plateau plateau = new Plateau(5, 5);
        var rover = new MarsRover(new int[]{1, 2}, N, plateau);

        rover.executeCommands("LMLMLMLMM");

        assertArrayEquals(new int[]{1, 3}, rover.getPosition());
        assertEquals(N, rover.getDirection());
    }

    @Test
    void testRotationOnly() {
        Plateau plateau = new Plateau(5, 5);
        MarsRover rover = new MarsRover(new int[]{3, 3}, E, plateau);

        rover.executeCommands("RRRR"); // Full rotation

        assertArrayEquals(new int[]{3, 3}, rover.getPosition());
        assertEquals(E, rover.getDirection());
    }

    @Test
    void testMovingOutOfBoundsIgnored() {
        Plateau plateau = new Plateau(5, 5);
        MarsRover rover = new MarsRover(new int[]{0, 0}, S, plateau);

        rover.executeCommands("M"); // Should be ignored

        assertArrayEquals(new int[]{0, 0}, rover.getPosition());
        assertEquals(S, rover.getDirection());
    }

    @Test
    void testMultipleMovesAndTurns() {
        Plateau plateau = new Plateau(5, 5);
        MarsRover rover = new MarsRover(new int[]{3, 3}, E, plateau);

        rover.executeCommands("MMRMMRMRRM");

        assertArrayEquals(new int[]{5, 1}, rover.getPosition(), "Rover position: " + Arrays.toString(rover.getPosition()));
        assertEquals(E, rover.getDirection());
    }

    @Test
    void testNoCommandInput() {
        Plateau plateau = new Plateau(5, 5);
        MarsRover rover = new MarsRover(new int[]{2, 2}, W, plateau);

        rover.executeCommands(""); // No-op

        assertArrayEquals(new int[]{2, 2}, rover.getPosition());
        assertEquals(W, rover.getDirection());
    }

    @Test
    void testInvalidCommandsIgnoredOrCauseException() {
        Plateau plateau = new Plateau(5, 5);
        MarsRover rover = new MarsRover(new int[]{1, 1}, N, plateau);

        // If invalid characters should be ignored
        rover.executeCommands("MMXLM");  // 'X' should be ignored
        assertArrayEquals(new int[]{0, 3}, rover.getPosition());
        assertEquals(W, rover.getDirection());

        // OR if they should throw an exception — update test accordingly
        // assertThrows(IllegalArgumentException.class, () -> rover.executeCommands("MX"));
    }

    @Test
    void testMultipleRoversInParallel() {
        Plateau plateau = new Plateau(5, 5);
        MarsRover rover1 = new MarsRover(new int[]{3, 3}, E, plateau);
        MarsRover rover2 = new MarsRover(new int[]{2, 2}, W, plateau);
        MarsRover rover3 = new MarsRover(new int[]{1, 1}, N, plateau);

        Callable<Void> task1 = () -> {
            rover1.executeCommands("MMRMMRMRRM");
            return null;
        };
        Callable<Void> task2 = () -> {
            rover2.executeCommands("");
            return null;
        };
        Callable<Void> task3 = () -> {
            rover3.executeCommands("MMXLM");
            return null;
        };

        try (ExecutorService executor = Executors.newFixedThreadPool(3)) {
            executor.submit(task1);
            executor.submit(task2);
            executor.submit(task3);
            executor.shutdown();
        }

        assertArrayEquals(new int[]{5, 1}, rover1.getPosition());
        assertEquals(E, rover1.getDirection());

        assertArrayEquals(new int[]{2, 2}, rover2.getPosition());
        assertEquals(W, rover2.getDirection());

        assertArrayEquals(new int[]{0, 3}, rover3.getPosition());
        assertEquals(W, rover3.getDirection());
    }
}
