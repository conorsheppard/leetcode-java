package com.leetcode.combinations_77.combination_strings_2;

public class Solution {
    public static String run(int input) {
        var result = new StringBuilder();
        combineDfs("", 1, input, result);
        if (!result.isEmpty()) result.setLength(result.length() - 1); // if present, remove final comma
        return result.toString();
    }

    private static void combineDfs(String current, int startDigit, int n, StringBuilder result) {
        if (current.length() == n) {
            result.append(current).append(",");
            return;
        }
        for (int i = startDigit; i <= 9; i++) combineDfs(current + i, i, n, result);
    }
}
