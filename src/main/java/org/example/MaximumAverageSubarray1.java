package org.example;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;

public class MaximumAverageSubarray1 {
    public static double findMaxAverage(int[] nums, int k) {
        double sum = Arrays.stream(nums).limit(k).sum();
        double max = sum;
        for (int i = k; i < nums.length; i++) {
            sum += nums[i] - nums[i - k];
            max = Math.max(max, sum);
        }
        return BigDecimal.valueOf(max / k)
                .setScale(5, RoundingMode.HALF_UP)
                .doubleValue();
    }
}
