package com.leetcode.spiral_order;

import java.util.*;
import java.util.stream.IntStream;

public class SpiralOrder {

    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        int m = matrix[0].length;
        int n = matrix.length;

        ArrayList<Stack<Integer>> stackList = new ArrayList<>(Arrays.stream(matrix).map(SpiralOrder::convertToStack).toList());
        IntStream.range(0, Math.min(m, n) * 2 - 1).anyMatch(i -> populateRes(res, stackList, i, m, n));
        return res;
    }

    private static boolean populateRes(List<Integer> res, ArrayList<Stack<Integer>> stackList, int i, int m, int n) {
        if (addLeftToRight(res, stackList) == m * n) return true;
        if (addTopToBottom(res, stackList) == m * n) return true;
        if (addRightToLeft(res, stackList) == m * n) return true;
        return addBottomToTop(res, stackList) == m * n;
    }

    private static int addLeftToRight(List<Integer> res, List<Stack<Integer>> stackList) {
        res.addAll(stackList.getFirst().stream().toList());
        stackList.removeFirst();
        return res.size();
    }

    private static int addTopToBottom(List<Integer> res, List<Stack<Integer>> stackList) {
        res.addAll(stackList.stream().mapToInt(Stack::pop).boxed().toList());
        return res.size();
    }

    private static int addRightToLeft(List<Integer> res, List<Stack<Integer>> stackList) {
        res.addAll(stackList.getLast().stream().sorted(Collections.reverseOrder((_, _) -> -1)).toList());
        stackList.removeLast();
        return res.size();
    }

    private static int addBottomToTop(List<Integer> res, List<Stack<Integer>> stackList) {
        res.addAll(stackList.stream().sorted(Collections.reverseOrder((_, _) -> -1)).mapToInt(List::removeFirst).boxed().toList());
        return res.size();
    }

    private static Stack<Integer> convertToStack(int[] array) {
        var res = new Stack<Integer>();
        Arrays.stream(array).boxed().forEach(res::add);
        return res;
    }

    public static List<Integer> spiralOrderLists(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        int m = matrix[0].length;
        int n = matrix.length;
        IntStream.range(0, Math.min(m, n) * 2 - 1).anyMatch(i -> populateResult(res, matrix, i, m, n));
        return res;
    }

    private static boolean populateResult(List<Integer> res, int[][] matrix, int i, int m, int n) {
        if (addAllLeftToRight(res, matrix, i, m) == m * n) return true;
        if (addAllTopToBottom(res, matrix, i, n) == m * n) return true;
        if (addRightToLeft(res, matrix, i, m) == m * n) return true;
        return addAllBottomToTop(res, matrix, i, n) == m * n;
    }

    private static int addAllLeftToRight(List<Integer> res, int[][] matrix, int i, int m) {
        res.addAll(Arrays.stream(matrix[i], i, m - i).boxed().toList());
        return res.size();
    }

    private static int addAllTopToBottom(List<Integer> res, int[][] matrix, int i, int n) {
        res.addAll(Arrays.stream(matrix, i + 1, n - i).mapToInt(arr -> arr[arr.length - 1 - i]).boxed().toList());
        return res.size();
    }

    private static int addRightToLeft(List<Integer> res, int[][] matrix, int i, int m) {
        List<Integer> rev = Arrays.stream(matrix[matrix.length - 1 - i]).boxed().sorted(Collections.reverseOrder((_, _) -> -1)).toList();
        res.addAll(IntStream.range(i + 1, m - i).map(rev::get).boxed().toList());
        return res.size();
    }

    private static int addAllBottomToTop(List<Integer> res, int[][] matrix, int i, int n) {
        List<Integer> rev2 = Arrays.stream(matrix).sorted(Collections.reverseOrder((_, _) -> -1)).mapToInt(arr -> arr[i]).boxed().toList();
        res.addAll(IntStream.range(i + 1, n - 1 - i).map(rev2::get).boxed().toList());
        return res.size();
    }

    public static List<Integer> spiralOrder1(int[][] matrix) {
        if (matrix.length == 1) return Arrays.stream(matrix[0]).boxed().toList();
        if (Arrays.stream(matrix).noneMatch(arr -> arr.length > 1))
            return Arrays.stream(matrix).flatMapToInt(Arrays::stream).boxed().toList();

        List<Integer> res = new ArrayList<>();
        int m = matrix[0].length;
        int n = matrix.length;
        for (int i = 0; i <= Math.min(m, n) * 2 - 1 || res.size() == m * n; i++) {
            res.addAll(Arrays.stream(matrix[i], i, m - i).boxed().toList());
            if (res.size() == m * n) break;
            final int indexOffset = i;
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

    public static List<Integer> spiralOrderOneMethod(int[][] matrix) {
        if (matrix.length == 1) return Arrays.stream(matrix[0]).boxed().toList();
        if (Arrays.stream(matrix).noneMatch(arr -> arr.length > 1))
            return Arrays.stream(matrix).flatMapToInt(Arrays::stream).boxed().toList();

        List<Integer> res = new ArrayList<>();
        int m = matrix[0].length;
        int n = matrix.length;
        for (int i = 0; i <= Math.min(m, n) * 2 - 1 || res.size() == m * n; i++) {
            addAll(res, matrix, i, m);
            if (res.size() == m * n) break;
            int indexOffset = i;
            Arrays.stream(matrix, i + 1, n - i).mapToInt(arr -> arr[arr.length - 1 - indexOffset]).toArray();
            var intArray = Arrays.stream(matrix, i + 1, n - i).mapToInt(arr -> arr[arr.length - 1 - indexOffset]).toArray();
            var newMatrix = new int[i + 1][n];
            newMatrix[i] = intArray;
            addAll(res, newMatrix, i, n - 1);
            if (res.size() == m * n) break;
            List<Integer> rev = Arrays.stream(matrix[matrix.length - 1 - i]).boxed().sorted(Collections.reverseOrder((_, _) -> -1)).toList();
            res.addAll(IntStream.range(i + 1, m - i).map(rev::get).boxed().toList());
            if (res.size() == m * n) break;
            List<Integer> rev2 = Arrays.stream(matrix).sorted(Collections.reverseOrder((_, _) -> -1)).mapToInt(arr -> arr[indexOffset]).boxed().toList();
            res.addAll(IntStream.range(i + 1, n - 1 - i).map(rev2::get).boxed().toList());
        }

        return res;
    }

    private static void addAll(List<Integer> list, int[][] matrix, int i, int dimension) {
        list.addAll(Arrays.stream(matrix[i], i, dimension - i).boxed().toList());
    }

    public static List<Integer> spiralOrder2(int[][] matrix) {
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
