package com.jue.java.learntest.leetcode.solution0083;

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head != null) {
            head.next = deleteDuplicates(head.next);
            return head.next != null && head.val == head.next.val ? head.next : head;
        } else {
            return null;
        }
    }
}