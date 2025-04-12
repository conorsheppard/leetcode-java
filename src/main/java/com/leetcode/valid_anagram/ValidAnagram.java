package com.leetcode.valid_anagram;

import java.util.Arrays;

public class ValidAnagram {
    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;

        var sChars = s.toCharArray();
        Arrays.sort(sChars);
        var sOrdered = new String(sChars);

        var tChars = t.toCharArray();
        Arrays.sort(tChars);
        var tOrdered = new String(tChars);

        return sOrdered.equals(tOrdered);
    }
}
