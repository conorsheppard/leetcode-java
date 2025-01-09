package org.example;

import java.util.Arrays;
import java.util.stream.IntStream;

public class MissingNumber {
    public static int missingNumber(int[] nums) {
        var sumOfNums = Arrays.stream(nums).sum();
        var sumWithMissing = IntStream.range(0, nums.length + 1).sum();
        return sumWithMissing - sumOfNums;
    }
}
