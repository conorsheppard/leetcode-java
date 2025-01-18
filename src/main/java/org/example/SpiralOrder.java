package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class SpiralOrder {

    public static List<Integer> spiralOrder(int[][] matrix) {
        if (matrix.length == 1) return Arrays.stream(matrix[0]).boxed().toList();
        if (Arrays.stream(matrix).noneMatch(arr -> arr.length > 1))
            return Arrays.stream(matrix).flatMapToInt(Arrays::stream).boxed().toList();

        List<Integer> res = new ArrayList<>();
        int m = matrix[0].length;
        int n = matrix.length;
        for (int i = 0; i <= Math.min(m, n) * 2 - 1 || res.size() == m * n; i++) {
            res.addAll(Arrays.stream(matrix[i], i, m - i).boxed().toList());
            if (res.size() == m * n) break;
            int indexOffset = i;
            res.addAll(Arrays.stream(matrix, i + 1, n - i).mapToInt(arr -> arr[arr.length - 1 - indexOffset]).boxed().toList());
            if (res.size() == m * n) break;
            List<Integer> rev = Arrays.stream(matrix[matrix.length - 1 - i]).boxed().sorted(Collections.reverseOrder((_, _) -> -1)).toList();
            res.addAll(IntStream.range(i + 1, m - i).map(rev::get).boxed().toList());
            if (res.size() == m * n) break;
            List<Integer> rev2 = Arrays.stream(matrix).sorted(Collections.reverseOrder((_, _) -> -1)).mapToInt(arr -> arr[indexOffset]).boxed().toList();
            res.addAll(IntStream.range(i + 1, n - 1 - i).map(rev2::get).boxed().toList());
        }

        return res;
    }

    public static List<Integer> spiralOrder1(int[][] matrix) {
        if (matrix.length == 1) return Arrays.stream(matrix[0]).boxed().toList();
        if (Arrays.stream(matrix).noneMatch(arr -> arr.length > 1))
            return Arrays.stream(matrix).flatMapToInt(Arrays::stream).boxed().toList();

        int m = matrix[0].length;
        int n = matrix.length;
        List<Integer> res = new ArrayList<>();
        int[] operation = new int[]{1, m, -1, -m};

        for (int i = 0; i <= Math.min(m, n) * 2 - 1; i++) {
            var op = operation[i % 4];
            addElems(res, op, (i % 2 == 0 ? m : n) - Math.ceilDiv(i, 2));
        }

        return res;
    }

    private static void addElems(List<Integer> res, int numToAdd, int numberOfTimes) {
        int cur = res.isEmpty() ? 0 : res.getLast();
        for (int i = 0; i < numberOfTimes; i++) {
            cur += numToAdd;
            res.add(cur);
        }
    }
}
