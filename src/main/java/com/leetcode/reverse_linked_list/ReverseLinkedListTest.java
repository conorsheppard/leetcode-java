package com.leetcode.reverse_linked_list;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ReverseLinkedListTest {
    @Test
    public void testCase1() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        var result = new ReverseLinkedList().reverseList(head);
        assertEquals(List.of(5, 4, 3, 2, 1), getLinkedListValues(result));
    }

    @Test
    public void testCase2() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);

        var result = new ReverseLinkedList().reverseList(head);
        assertEquals(List.of(2, 1), getLinkedListValues(result));
    }

    @Test
    public void testCase3() {
        ListNode head = null;

        var result = new ReverseLinkedList().reverseList(head);
        assertEquals(List.of(), getLinkedListValues(result));
    }

    private ArrayList<Integer> getLinkedListValues(ListNode node) {
        var cur = node;
        var res = new ArrayList<Integer>();
        while (cur != null) {
            res.add(cur.val);
            cur = cur.next;
        }
        return res;
    }
}
