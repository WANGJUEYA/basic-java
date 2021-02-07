//给定一个单链表 L：L0→L1→…→Ln-1→Ln ， 
//将其重新排列后变为： L0→Ln→L1→Ln-1→L2→Ln-2→… 
//
// 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。 
//
// 示例 1: 
//
// 给定链表 1->2->3->4, 重新排列为 1->4->2->3. 
//
// 示例 2: 
//
// 给定链表 1->2->3->4->5, 重新排列为 1->5->2->4->3. 
// Related Topics 链表 
// 👍 410 👎 0


package com.jue.java.learn.leetcode.editor.cn.ReorderList;

import com.jue.java.learn.tooffer.bean.ListNode;

/**
 * @author JUE
 * @number 143
 */
public class ReorderList {
    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode head = new ListNode(new int[]{1, 2, 3, 4, 5});
        solution.reorderList(head);
        System.out.println(head);
    }
}

//leetcode submit region begin(Prohibit modification and deletion)

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    // 最笨的做法, 取当前链表的第一, 取当前链表的最后
    // fixme 比较优秀的解法是寻找中点, 然后反转后半部分
    public void reorderList(ListNode head) {
        if (head == null) {
            return;
        }
        ListNode mid = middleNode(head);
        ListNode l2 = mid.next;
        mid.next = null;
        l2 = reverseList(l2);
        mergeList(head, l2);
    }

    public ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        return prev;
    }

    public void mergeList(ListNode l1, ListNode l2) {
        ListNode l1_tmp;
        ListNode l2_tmp;
        while (l1 != null && l2 != null) {
            l1_tmp = l1.next;
            l2_tmp = l2.next;

            l1.next = l2;
            l1 = l1_tmp;

            l2.next = l1;
            l2 = l2_tmp;
        }
    }

    /*
    public void reorderList1(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }
        ListNode result = head;
        ListNode sub = head.next;
        boolean first = false;
        while (true) {
            if (sub.next == null) {
                result.next = sub;
                return;
            }
            if (first) {
                result.next = sub;
                sub = sub.next;
            } else {
                ListNode pre = sub;
                ListNode p = sub;
                while (p.next != null) {
                    pre = p;
                    p = p.next;
                }
                pre.next = null;
                result.next = p;
            }
            result = result.next;
            first = !first;
        }
    }
    */
}
//leetcode submit region end(Prohibit modification and deletion)
