package com.leetcode.top_k_frequent_elements;

import java.util.*;
import java.util.Map.Entry;

public class TopKFrequentElements {
    static int[] topKFrequent(int[] nums, int k) {
        if (nums.length == 0 || k == 0) return new int[]{};

        var map = new HashMap<Integer, Integer>();
        var heap = new PriorityQueue<>(k, Comparator.comparing(Entry<Integer, Integer>::getValue).reversed());
        var res = new int[k];

        for (int num : nums) map.put(num, map.getOrDefault(num, 0) + 1);
        heap.addAll(map.entrySet());

        for (int i = 0; i < k; i++) res[i] = heap.poll().getKey();

        return res;
    }

    /**
     * private indicates intent of use, this is just a utility Record to be used solely in this class
     */
    private record Node(Integer num, Integer freq) { // implements Comparable<Node> {
        /*
        @Override
        public int compareTo(Node node) {
            return Integer.compare(node.freq(), freq);
        }
        */
    }

    static int[] topKFreq(int[] nums, int k) {
        if (nums.length == 0 || k == 0) return new int[]{};
        var res = new int[k];
        var m = new HashMap<Integer, Integer>();
        var pq = new PriorityQueue<>(Comparator.comparing(Entry<Integer, Integer>::getValue));
        for (int n : nums) m.put(n, m.getOrDefault(n, 0) + 1);
        pq.addAll(m.entrySet());
        for (int i = 0; i < k; i++) res[i] = pq.poll().getValue();
        return res;
    }

    static int[] topKFreqFunctional(int[] nums, int k) {
        if (nums.length == 0 || k == 0) return new int[0];

        var freqMap = new HashMap<Integer, Integer>();
        for (int num : nums) freqMap.merge(num, 1, Integer::sum);

        return freqMap.entrySet().stream()
                .sorted((a, b) -> b.getValue() - a.getValue())
                .limit(k)
                .mapToInt(Map.Entry::getKey)
                .toArray();
    }
}
