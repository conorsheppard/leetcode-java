package com.leetcode.linked_list_cycle;

import org.junit.jupiter.api.Test;

import static com.leetcode.linked_list_cycle.LinkedListCycle.hasCycle;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LinkedListCycleTest {

    @Test
    void testCase1() {
        ListNode head = new ListNode(3);
        head.next = new ListNode(2);
        var cycle = head.next;
        head.next.next = new ListNode(0);
        head.next.next.next = new ListNode(-4);
        head.next.next.next.next = cycle;

        assertTrue(hasCycle(head));
    }

    @Test
    void testCase2() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = head.next;

        assertTrue(hasCycle(head));
    }

    @Test
    void testCase3() {
        assertFalse(hasCycle(new ListNode(1)));
    }
}
