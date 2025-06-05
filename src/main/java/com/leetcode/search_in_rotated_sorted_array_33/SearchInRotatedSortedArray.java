package com.leetcode.search_in_rotated_sorted_array_33;

import java.util.Arrays;

public class SearchInRotatedSortedArray {
    // you can't simply do nums[i] > target because if the target is a small number but it's rotated past the midway
    // point, then discarding all the elements to the right (after doing nums[i] > target) will remove the target we're looking for
    public static int search(int[] nums, int target) {
        int piv = 0;
        for (int i = nums.length / 2; i >= 0; i = i / 2) {
            if (nums[i] == target) return piv + i;
            // is the current number bigger or smaller than the target
            // are the smaller numbers to the right or to the left
            if (nums[i] > target) {
                // if the first number is greater than the target, then the target lies to the right of the current middle number
                // if smaller numbers are to the right, discard the left
                // otherwise discard the right
                if (nums[0] > target) {
                    // discard the left
                    nums = Arrays.copyOfRange(nums, i, nums.length);
                    piv += i;
                } else {
                    // discard the right
                    nums = Arrays.copyOf(nums, i);
                }
            } else {
                if (nums[0] > target) {
                    // discard the left
                    nums = Arrays.copyOfRange(nums, i, nums.length);
                    piv += i;
                } else {
                    // discard the right
                    nums = Arrays.copyOf(nums, i);
                }
            }
            if (i == 0) return -1;
        }
        return piv;
    }
}
