package com.leetcode.combinations_77;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Combinations {
    public List<List<Integer>> combine(int n, int k) {
        if (n == 1) return List.of(IntStream.rangeClosed(1, k).boxed().toList());

        var res = new ArrayList<List<Integer>>();

        for (int i = 1; i <= n; i++) combineDfs(k, n, new ArrayList<>(), res, i);

        return res;
    }

    private void combineDfs(int maxDepth, int maxBranches, ArrayList<Integer> curComb,
                            ArrayList<List<Integer>> combinations, int curVal) {
        curComb.add(curVal);
        if (curComb.size() == maxDepth) {
            combinations.add(curComb);
            return;
        }

        while (curVal < maxBranches) {
            combineDfs(maxDepth, maxBranches, new ArrayList<>(curComb), combinations, curVal + 1);
            curVal++;
        }
    }
}
