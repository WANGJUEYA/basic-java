package com.jue.java.learn.tooffer.solution08;

import com.jue.java.learn.tooffer.bean.ListNode;

import java.util.Stack;

public class Solution {
    public ListNode FindKthToTail(ListNode head, int k) {
        //1、用空间换时间
        Stack<ListNode> stack = new Stack<>();
        ListNode node = head;
        while (node != null) {
            stack.push(node);
            node = node.next;
        }
        ListNode result = null;
        while (k > 0) {
            if (stack.empty()) {
                result = null;
            } else {
                result = stack.pop();
            }
            k--;
        }
        return result;
    }
}