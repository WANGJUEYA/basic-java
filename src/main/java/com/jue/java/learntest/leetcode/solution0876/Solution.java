package com.jue.java.learntest.leetcode.solution0876;

import com.jue.java.learntest.tooffer.bean.ListNode;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode middleNode(ListNode head) {
        ListNode p = head, m = head;
        int pCount = 1, mCount = 1;
        while (p.next != null) {
            p = p.next;
            pCount++;
            while (mCount < (pCount / 2) + 1) {
                m = m.next;
                mCount++;
            }
        }
        return m;
    }
}