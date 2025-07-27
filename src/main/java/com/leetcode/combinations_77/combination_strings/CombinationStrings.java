package com.leetcode.combinations_77.combination_strings;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class CombinationStrings {
    public List<String> combine(int n, int k) {
        if (n == 1) return List.of(getStrRep(IntStream.rangeClosed(1, k).boxed().toList()));
        var res = new ArrayList<String>();
        for (int i = 1; i <= n; i++) combineDfs(n, k, res, new ArrayList<>(), i);
        return res;
    }

    private void combineDfs(int maxBranches, int maxDepth, List<String> combinations, List<Integer> curComb, int curVal) {
        curComb.add(curVal);
        if (curComb.size() == maxDepth) {
            combinations.add(getStrRep(curComb));
            return;
        }

        while (curVal < maxBranches) {
            combineDfs(maxBranches, maxDepth, combinations, new ArrayList<>(curComb), curVal + 1);
            curVal++;
        }
    }

    private String getStrRep(List<Integer> combination) {
        return combination.toString().replaceAll("\\[|]|,|\\s", "");
    }
}
