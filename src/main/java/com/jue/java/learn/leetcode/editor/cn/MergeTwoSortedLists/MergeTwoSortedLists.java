//将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
//
// 
//
// 示例： 
//
// 输入：1->2->4, 1->3->4
//输出：1->1->2->3->4->4
// 
// Related Topics 链表


package com.jue.java.learn.leetcode.editor.cn.MergeTwoSortedLists;

import com.jue.java.learn.tooffer.bean.ListNode;

/**
 * @author JUE
 * @number 21
 */
public class MergeTwoSortedLists {
    public static void main(String[] args) {
        Solution solution = new Solution();
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
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode result = null;
        ListNode next = null;
        ListNode head1 = l1;
        ListNode head2 = l2;
        while (head1 != null && head2 != null) {
            ListNode tmp;
            if (head1.val < head2.val) {
                tmp = head1;
                head1 = head1.next;
            } else {
                tmp = head2;
                head2 = head2.next;
            }
            if (result == null) {
                result = tmp;
            }
            if (next == null) {
                next = tmp;
            } else {
                next.next = tmp;
                next = next.next;
            }

        }

        if (result == null || next == null) {
            return head1 == null ? head2 : head1;
        } else {
            next.next = head1 == null ? head2 : head1;
            return result;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
