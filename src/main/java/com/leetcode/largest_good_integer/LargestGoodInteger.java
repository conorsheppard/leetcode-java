package com.leetcode.largest_good_integer;

public class LargestGoodInteger {
    static String largestGoodInteger(String nums) {
        char[] nos = nums.toCharArray();
        int max = -1;
        for (int i = 0; i <= nos.length - 3; i++) {
            char a = nos[i], b = nos[i + 1], c = nos[i + 2];
            String cur = "" + a + b + c;
            if (a == b && a == c && Integer.parseInt(cur) > max) {
                max = Integer.parseInt(cur);
            }
        }
        if (max == -1) return "";
        return max == 0 ? "000" : max + "";
    }
}
