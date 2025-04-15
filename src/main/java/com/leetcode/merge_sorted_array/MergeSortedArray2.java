package com.leetcode.merge_sorted_array;

import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Collectors;

public class MergeSortedArray2 {

    public static void main(String[] args) {
        mergeTwoPointersInPlace(new int[]{1, 2, 3, 0, 0, 0}, 3, new int[]{2, 5, 6}, 3);
    }

    static void mergeTwoPointersInPlace(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1, j = n - 1, k = m + n - 1;

        // Merge from the back
        while (i >= 0 && j >= 0) {
            if (nums1[i] > nums2[j]) {
                nums1[k--] = nums1[i--];
            } else {
                nums1[k--] = nums2[j--];
            }
        }

        // Copy remaining nums2 elements if any
        while (j >= 0) {
            nums1[k--] = nums2[j--];
        }

        System.out.println(Arrays.toString(nums1));
    }

    static void mergeTwoPointers(int[] nums1, int m, int[] nums2, int n) {
        int[] merged = new int[m + n];

        // i is the index in nums1, j is the index in nums2, k is the index of the new sorted array
        int i = 0, j = 0, k = 0;

        while (i < m && j < n) {
            // if the number at the current index (i) in nums1 is less than the number at the current index in nums2 (j),
            // then add nums1[i] to the sorted array
            if (nums1[i] < nums2[j]) merged[k++] = nums1[i++];
            else merged[k++] = nums2[j++];
        }

        // add the remaining elements
        while (i < m) merged[k++] = nums1[i++];
        while (j < n) merged[k++] = nums2[j++];

        System.out.println(Arrays.toString(merged));
    }

    static void mergeCollectionsSort(int[] nums1, int m, int[] nums2, int n) {
        int[] merged = new int[m + n];
        System.arraycopy(nums1, 0, merged, 0, m);
        System.arraycopy(nums2, 0, merged, m, n);

        var result = Arrays.stream(merged).boxed().collect(Collectors.toList());

        Collections.sort(result);

        System.out.println(result);
    }
}
