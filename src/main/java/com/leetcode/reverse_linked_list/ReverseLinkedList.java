package com.leetcode.reverse_linked_list;

public class ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;

        while (head != null) {
            var next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }

        return prev;
    }
}