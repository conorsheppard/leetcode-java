package com.leetcode.linked_list_cycle;

public class LinkedListCycle {
    static boolean hasCycle(ListNode head) {
        boolean hasCycle = false;
        if (head == null || head.next == null) return hasCycle;
        ListNode slow = head;
        ListNode fast = head;

        while (!hasCycle) {
            if (slow.next != null) slow = slow.next;

            if (fast.next == null || fast.next.next == null) break;

            fast = fast.next.next;

            if (fast == slow) {
                hasCycle = true;
                break;
            }
        }

        return hasCycle;
    }

    static boolean hasCycleImproved(ListNode head) {
        if (head == null || head.next == null) return false;

        ListNode slow = head;
        ListNode fast = head.next;

        while (fast != null && fast.next != null) {
            if (slow == fast) return true;
            slow = slow.next;
            fast = fast.next.next;
        }

        return false;
    }
}
