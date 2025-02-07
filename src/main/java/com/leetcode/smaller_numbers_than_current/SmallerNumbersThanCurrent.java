package com.leetcode.smaller_numbers_than_current;

public class SmallerNumbersThanCurrent {
    public static int[] smallerNumbersThanCurrent(int[] nums) {
        var res = new int[nums.length];
        for (int i = 0; i < nums.length; i++)
            for (int num : nums) if (nums[i] > num) res[i] = ++res[i];
        return res;
    }
}
