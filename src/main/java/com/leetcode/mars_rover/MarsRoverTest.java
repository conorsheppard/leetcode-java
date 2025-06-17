package com.leetcode.mars_rover;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

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
                        new MarsRover(new int[]{1, 3}, E, new Plateau(5, 5)))
        );
    }

    @Test
    void testBasicMovement() {
        Plateau plateau = new Plateau(5, 5);
        var rover = new MarsRover(new int[]{1, 2}, Direction.N, plateau);

        rover.executeCommands("LMLMLMLMM");

        assertArrayEquals(new int[]{1, 3}, rover.getPosition());
        assertEquals(Direction.N, rover.getDirection());
    }

    @Test
    void testRotationOnly() {
        Plateau plateau = new Plateau(5, 5);
        MarsRover rover = new MarsRover(new int[]{3, 3}, Direction.E, plateau);

        rover.executeCommands("RRRR"); // Full rotation

        assertArrayEquals(new int[]{3, 3}, rover.getPosition());
        assertEquals(Direction.E, rover.getDirection());
    }

    @Test
    void testMovingOutOfBoundsIgnored() {
        Plateau plateau = new Plateau(5, 5);
        MarsRover rover = new MarsRover(new int[]{0, 0}, Direction.S, plateau);

        rover.executeCommands("M"); // Should be ignored

        assertArrayEquals(new int[]{0, 0}, rover.getPosition());
        assertEquals(Direction.S, rover.getDirection());
    }

    @Test
    void testMultipleMovesAndTurns() {
        Plateau plateau = new Plateau(5, 5);
        MarsRover rover = new MarsRover(new int[]{3, 3}, Direction.E, plateau);

        rover.executeCommands("MMRMMRMRRM");

        assertArrayEquals(new int[]{5, 1}, rover.getPosition());
        assertEquals(Direction.E, rover.getDirection());
    }

    @Test
    void testNoCommandInput() {
        Plateau plateau = new Plateau(5, 5);
        MarsRover rover = new MarsRover(new int[]{2, 2}, Direction.W, plateau);

        rover.executeCommands(""); // No-op

        assertArrayEquals(new int[]{2, 2}, rover.getPosition());
        assertEquals(Direction.W, rover.getDirection());
    }

    @Test
    void testInvalidCommandsIgnoredOrCauseException() {
        Plateau plateau = new Plateau(5, 5);
        MarsRover rover = new MarsRover(new int[]{1, 1}, Direction.N, plateau);

        // If invalid characters should be ignored
        rover.executeCommands("MMXLM");  // 'X' should be ignored
        assertArrayEquals(new int[]{0, 3}, rover.getPosition());
        assertEquals(Direction.W, rover.getDirection());

        // OR if they should throw an exception — update test accordingly
        // assertThrows(IllegalArgumentException.class, () -> rover.executeCommands("MX"));
    }
}
