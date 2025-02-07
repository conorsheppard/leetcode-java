package com.leetcode.final_value_after_operations;

import java.util.Arrays;

public class FinalValueAfterOperations {
    public static int finalValueAfterOperations(String[] operations) {
        return Arrays.stream(operations).map(op -> op.charAt(1) == '-' ? -1 : 1).reduce(0, Integer::sum);
//        return Arrays.stream(operations).mapToInt(op -> op.contains("-") ? -1 : 1).sum();
    }

    public static int finalValueAfterOperations1(String[] operations) {
        var res = 0;
        for (String op : operations) {
            if (op.contains("++")) res++;
            else res--;
        }
        return res;
    }
}
