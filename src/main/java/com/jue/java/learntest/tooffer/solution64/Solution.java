package com.jue.java.learntest.tooffer.solution64;

import com.jue.java.learntest.tooffer.bean.ListNode;

public class Solution {
    public static void main(String[] args) {
        int[] test1 = {1, 2, 3, 3, 4, 4, 5};
        int[] test2 = {1, 1, 1, 1, 1, 1};
        int[] test = {1, 1, 2, 3, 3, 4, 5, 5};
        System.out.println((new Solution()).deleteDuplication(new ListNode(test)));
    }

    public ListNode deleteDuplication(ListNode pHead) {
        if (pHead == null || pHead.next == null) {
            return pHead;
        }
        ListNode temp = null;
        int val;
        //判断首节点是否重复
        while (pHead.val == pHead.next.val) {
            temp = pHead.next;
            val = pHead.val;
            while (temp != null && temp.val == val) {
                temp = temp.next;
            }
            pHead = temp;
            if (pHead == null || pHead.next == null) {
                return pHead;
            }
        }
        ListNode last = pHead;
        temp = pHead.next;
        while (temp != null) {
            if (temp.next == null || temp.val != temp.next.val) {
                last.next = temp;
                last = temp;
                temp = temp.next;
            } else {
                val = temp.val;
                while (temp != null && temp.val == val) {
                    temp = temp.next;
                }
            }
        }
        last.next = null;
        return pHead;
    }
}