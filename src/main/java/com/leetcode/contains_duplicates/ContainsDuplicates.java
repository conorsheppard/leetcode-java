package com.leetcode.contains_duplicates;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class ContainsDuplicates {
    public static boolean containsDuplicates(int[] nums) {
        List<Integer> numsList = Arrays.stream(nums).boxed().toList();
        HashSet<Integer> numsSet = new HashSet<>(numsList);
        return numsSet.size() < nums.length;
    }
}
