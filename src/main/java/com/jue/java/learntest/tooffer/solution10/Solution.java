package com.jue.java.learntest.tooffer.solution10;

import com.jue.java.learntest.tooffer.bean.ListNode;

public class Solution {
    public ListNode ReverseList(ListNode head) {
        ListNode last = null;
        ListNode next;
        while (head != null) {
            next = head.next;
            head.next = last;
            last = head;
            head = next;
        }
        return last;
    }
}