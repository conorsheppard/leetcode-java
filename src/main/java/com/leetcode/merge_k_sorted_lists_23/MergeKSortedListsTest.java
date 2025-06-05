package com.leetcode.merge_k_sorted_lists_23;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.*;

public class MergeKSortedListsTest {

    private final MergeKSortedLists merger = new MergeKSortedLists();

    // Helper to create a ListNode chain from an array
    private ListNode buildList(int... values) {
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        for (int val : values) {
            current = current.next = new ListNode(val);
        }
        return dummy.next;
    }

    // Helper to convert ListNode to list of integers for easier assertions
    private List<Integer> toList(ListNode node) {
        List<Integer> result = new ArrayList<>();
        while (node != null) {
            result.add(node.val);
            node = node.next;
        }
        return result;
    }

    @Test
    public void testMergeThreeSortedLists() {
        ListNode[] lists = new ListNode[] {
                buildList(1, 4, 5),
                buildList(1, 3, 4),
                buildList(2, 6)
        };
        ListNode merged = merger.mergeKLists(lists);
        assertEquals(List.of(1, 1, 2, 3, 4, 4, 5, 6), toList(merged));
    }

    @Test
    public void testMergeEmptyListArray() {
        ListNode[] lists = new ListNode[0];
        ListNode merged = merger.mergeKLists(lists);
        assertNull(merged);
    }

    @Test
    public void testMergeArrayWithAllNulls() {
        ListNode[] lists = new ListNode[] {null, null, null};
        ListNode merged = merger.mergeKLists(lists);
        assertNull(merged);
    }

    @Test
    public void testMergeSingleList() {
        ListNode[] lists = new ListNode[] {
                buildList(1, 2, 3)
        };
        ListNode merged = merger.mergeKLists(lists);
        assertEquals(List.of(1, 2, 3), toList(merged));
    }

    @Test
    public void testMergeWithSomeNulls() {
        ListNode[] lists = new ListNode[] {
                null,
                buildList(5),
                null,
                buildList(1, 4)
        };
        ListNode merged = merger.mergeKLists(lists);
        assertEquals(List.of(1, 4, 5), toList(merged));
    }
}
