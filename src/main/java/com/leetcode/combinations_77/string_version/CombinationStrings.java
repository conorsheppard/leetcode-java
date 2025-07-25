package com.leetcode.combinations_77.string_version;

import java.util.List;
import java.util.stream.IntStream;

public class CombinationStrings {
    public List<String> combine(int n, int k) {
        if (n == 1) return List.of(IntStream.rangeClosed(1, k).boxed().toList().toString());
        return List.of();
    }
}
