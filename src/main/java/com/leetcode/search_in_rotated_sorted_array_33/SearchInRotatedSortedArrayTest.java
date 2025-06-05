package com.leetcode.search_in_rotated_sorted_array_33;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static com.leetcode.search_in_rotated_sorted_array_33.SearchInRotatedSortedArray.search;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SearchInRotatedSortedArrayTest {
    static Stream<TestCase> testCases() {
        return Stream.of(
                new TestCase(new int[]{4, 5, 6, 7, 0, 1, 2}, 5, 1),
                new TestCase(new int[]{4, 5, 6, 7, 0, 1, 2}, 1, 5),
                new TestCase(new int[]{4, 5, 6, 7, 0, 1, 2}, 3, -1),
                new TestCase(new int[]{1}, 1, 0),
                new TestCase(new int[]{1}, 2, -1),
                new TestCase(new int[]{}, 5, -1),
                new TestCase(new int[]{1, 2, 3, 4, 5, 6, 7}, 4, 3),
                new TestCase(new int[]{6, 7, 0, 1, 2, 3, 4, 5}, 0, 2),
                new TestCase(new int[]{6, 7, 1, 2, 3, 4, 5}, 5, 6)
        );
    }

    @ParameterizedTest(name = "[{index}] search({0}) => {2}")
    @MethodSource("testCases")
    @DisplayName("Search in Rotated Sorted Array")
    void testSearchInRotatedSortedArray(TestCase tc) {
        assertEquals(tc.expectedIndex, search(tc.nums, tc.target),
                () -> "Failed for input: " + arrayToString(tc.nums) + ", target=" + tc.target);
    }

    // Helper to make arrays more readable in error messages
    private String arrayToString(int[] arr) {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < arr.length; i++) {
            sb.append(arr[i]);
            if (i < arr.length - 1) sb.append(", ");
        }
        sb.append("]");
        return sb.toString();
    }

    private static class TestCase {
        int[] nums;
        int target;
        int expectedIndex;

        TestCase(int[] nums, int target, int expectedIndex) {
            this.nums = nums;
            this.target = target;
            this.expectedIndex = expectedIndex;
        }

        @Override
        public String toString() {
            return "nums=" + arrayToString(nums) + ", target=" + target + ", expected=" + expectedIndex;
        }

        private String arrayToString(int[] arr) {
            StringBuilder sb = new StringBuilder("[");
            for (int i = 0; i < arr.length; i++) {
                sb.append(arr[i]);
                if (i < arr.length - 1) sb.append(", ");
            }
            sb.append("]");
            return sb.toString();
        }
    }
}
