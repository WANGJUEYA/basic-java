package com.jue.java.learntest.leetcode.solution0445;

import com.jue.java.learntest.tooffer.bean.ListNode;

import java.util.Stack;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> stack1 = new Stack<>();
        while (l1 != null) {
            stack1.add(l1.val);
            l1 = l1.next;
        }
        Stack<Integer> stack2 = new Stack<>();
        while (l2 != null) {
            stack2.add(l2.val);
            l2 = l2.next;
        }
        int add = 0, item;
        ListNode result = null;
        while (!stack1.empty() || !stack2.empty()) {
            item = add;
            item += stack1.empty() ? 0 : stack1.pop();
            item += stack2.empty() ? 0 : stack2.pop();
            add = item / 10;
            ListNode temp = new ListNode(item % 10);
            temp.next = result;
            result = temp;
        }
        return result;
    }
}