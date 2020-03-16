package com.jue.java.learntest.tooffer.solution09;

import com.jue.java.learntest.tooffer.bean.ListNode;

public class Solution {
    public ListNode Merge(ListNode list1, ListNode list2) {

        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }
        ListNode result, circle;
        if (list1.val < list2.val) {
            result = list1;
            circle = list2;
        } else {
            result = list2;
            circle = list1;
        }
        ListNode node = result;
        while (circle != null) {
            //当下一个不存在时直接放后
            if (node.next == null) {
                node.next = circle;
                break;
            }
            //当小于等于前面插入,否则下一个
            if (circle.val <= node.next.val) {
                ListNode temp = circle.next;
                circle.next = node.next;
                node.next = circle;
                circle = temp;
            }
            node = node.next;
        }
        return result;
    }
}