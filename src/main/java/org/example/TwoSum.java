package org.example;

import java.util.HashMap;
import java.util.Objects;

public class TwoSum {

    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (!Objects.isNull(map.get(nums[i]))) {
                return new int[]{map.get(nums[i]), i};
            } else {
                map.put(Math.abs(target-nums[i]), i);
            }
        }
        return new int[]{};
    }
}
