package com.leetcode.move_zeros_283;

public class MoveZeros {
    public void moveZeroes(int[] nums) {
        // int cur: the current smallest swappable index in the array
        for (int i = 0, cur = 0; i < nums.length; i++)
            if (nums[i] != 0) swap(nums, i, cur++);
    }

    private void swap(int[] nums, int firstIndex, int secondIndex) {
        var temp = nums[firstIndex];
        nums[firstIndex] = nums[secondIndex];
        nums[secondIndex] = temp;
    }
}
