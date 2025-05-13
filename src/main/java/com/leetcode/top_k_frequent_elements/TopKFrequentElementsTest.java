package com.leetcode.top_k_frequent_elements;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static com.leetcode.top_k_frequent_elements.TopKFrequentElements.topKFrequent;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TopKFrequentElementsTest {
    static Stream<Arguments> provideTestCases() {
        return Stream.of(
                Arguments.of(new int[]{1, 1, 1, 2, 2, 3}, 2, List.of(1, 2)),
                Arguments.of(new int[]{1}, 1, List.of(1)),
                Arguments.of(new int[]{2, 2, 3, 1, 1, 1}, 2, List.of(1, 2)),
                Arguments.of(new int[]{}, 2, List.of()),
                Arguments.of(new int[]{2, 2, 3, 3, 3, 3, 3, 1, 1, 1}, 2, List.of(1, 3))
        );
    }

    @ParameterizedTest
    @MethodSource("provideTestCases")
    void testTopKFrequent(int[] nums, int k, List<Integer> expected) {
        var result = topKFrequent(nums, k);
        assertTrue(arrayConv(result).containsAll(expected) && expected.containsAll(arrayConv(result)),
                "Expected " + expected + " but got " + arrayConv(result));
    }

    private static List<Integer> arrayConv(int[] result) {
        return Arrays.stream(result).boxed().toList();
    }
}
