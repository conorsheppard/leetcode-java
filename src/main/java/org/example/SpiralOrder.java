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
            int limitStart = i;
            int limitEnd = ((i % 2 == 0 ? m : n) - Math.ceilDiv(i, 2));
            res.addAll(Arrays.stream(matrix[i], limitStart, limitEnd).boxed().toList());
            if (res.size() == m * n) break;
            res.addAll(Arrays.stream(matrix, limitStart + 1, limitEnd).mapToInt(arr -> arr[arr.length - 1]).boxed().toList());
            if (res.size() == m * n) break;
//            res.addAll(Arrays.stream(matrix[matrix.length - 1]).boxed().sorted(Collections.reverseOrder()).limit(limitEnd).toList());
            List<Integer> rev = Arrays.stream(matrix[matrix.length - 1 - i]).boxed().sorted(Collections.reverseOrder()).toList();
            res.addAll(IntStream.range(limitStart + 1, limitEnd).map(rev::get).boxed().toList());
            if (res.size() == m * n) break;
//            res.addAll(Arrays.stream(matrix).sorted(Collections.reverseOrder((_, _) -> -1)).mapToInt(arr -> arr[0]).limit(limitEnd).boxed().toList());
            List<Integer> rev2 = Arrays.stream(matrix).sorted(Collections.reverseOrder((_, _) -> -1)).mapToInt(arr -> arr[0]).boxed().toList();
            res.addAll(IntStream.range(limitStart + 1, limitEnd - 1).map(rev2::get).boxed().toList());
//            Stream.of(matrix).collect(Collectors.toCollection(ArrayDeque::new)).descendingIterator().forEachRemaining(arr -> res.add(arr[0]));
        }

        return res;
    }

    /**
    * for i = 1; i < n; i++
    * increase by 1 m-1 number of times
    * increase by m n-1 number of times
    * decrease by 1 m-1 times
    * decrease by m n-2 times
    * increase by 1 m-2 times
    * */
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
