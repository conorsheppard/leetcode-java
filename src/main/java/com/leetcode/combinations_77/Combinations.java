package com.leetcode.combinations_77;

import java.util.ArrayList;
import java.util.List;

public class Combinations {
    public List<List<Integer>> combine(int n, int k) {
        var res = new ArrayList<List<Integer>>(); // res.get(i).size() == k, i.e. inner List<Integer> size == k
        for (int i = 1; i < n; i++) {
            combineDfs(k, n, new ArrayList<>(), res, 1, i);
        }

        return res;
    }

    private void combineDfs(int maxDepth, int maxBranches, ArrayList<Integer> curComb,
                            ArrayList<List<Integer>> combinations, int curDepth, int curVal) {
        curComb.add(curVal);
        if (curDepth == maxDepth) {
            combinations.add(curComb);
            return;
        }

        while (curVal < maxBranches) {
            combineDfs(maxDepth, maxBranches, new ArrayList<>(curComb), combinations, curDepth + 1, curVal + 1);
            curVal++;
        }
    }

    public List<List<Integer>> combineIterative(int n, int k) {
        var res = new ArrayList<List<Integer>>(); // res.get(i).size() == k, i.e. inner List<Integer> size == k
        for (int i = 1; i <= n; i++) {
            for (int j = i; j <= n; j++) {
                var combination = new ArrayList<Integer>();
                for (int q = 1; q <= k; q++) {
                    combination.add(j);
                }
                res.add(combination);
            }
        }
        return res;
    }
}
