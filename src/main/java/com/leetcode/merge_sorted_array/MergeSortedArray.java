package com.leetcode.merge_sorted_array;

public class MergeSortedArray {

    public static int[] merge(int[] nums1, int m, int[] nums2, int n) {
        if (n == 0) {
            return nums1;
        }
        if (m == 0) {
            return nums2;
        }
        int[] newNums = new int[m + n];
        int index = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < (m + n); j++) {
                // if j is greater or equal to m, add the rest of the contents to newNums[]
                if (j >= m) {
                    for (int k = m + 1; k < (m + n); k++) {
                        newNums[k] = nums2[i];
                        i++;
                        j++;
                    }
                } else if (nums2[i] < nums1[j]) {
                    newNums[index] = nums2[i]; // index++
                    i++;
                    index++;
                } else if (nums1[j] < nums2[i]) {
                    newNums[index] = nums1[j]; // index++
                    index++;
                } else if (nums1[j] == nums2[i]) {
                    newNums[index] = nums1[j]; // index++
                    index++;
                    newNums[index] = nums2[i]; // index++
                    index++;
                    i++;
                }
            }
        }
        nums1 = newNums;
//        for (int y = 0; y < nums1.length; y++) nums1[y] = newNums[y];
        return nums1;
    }

    public void mergeLeetCodeVersion(int[] nums1, int m, int[] nums2, int n) {
        if (n == 0) {
            return;
        }
        if (m == 0) {
            nums1[0] = nums2[0];
            return;
        }
        int[] newNums = new int[m+n];
        int index = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < (m+n); j++) {
                if (j >= m) {
                    for (int k = m + 1; k < (m + n); k++) {
                        newNums[k] = nums2[i++];
                        j++;
                    }
                } else if (nums2[i] < nums1[j]) {
                    newNums[index++] = nums2[i++];
                } else if (nums1[j] < nums2[i]) {
                    newNums[index++] = nums1[j];
                } else if (nums1[j] == nums2[i]) {
                    newNums[index++] = nums1[j];
                    newNums[index++] = nums2[i++];
                }
            }
        }
        System.arraycopy(newNums, 0, nums1, 0, nums1.length);
    }
}
