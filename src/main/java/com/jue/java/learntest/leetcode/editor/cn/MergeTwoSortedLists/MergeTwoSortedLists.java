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


package com.jue.java.learntest.leetcode.editor.cn.MergeTwoSortedLists;

import com.jue.java.learntest.tooffer.bean.ListNode;

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
        ListNode head = null;
        if (l1 == null) {
            head = l2;
        } else if (l2 == null) {
            head = l1;
        } else {
            if (l1.val < l2.val) {
                head = l1;
                head.next = mergeTwoLists(l1.next, l2);
            } else {
                head = l2;
                head.next = mergeTwoLists(l1, l2.next);
            }
        }
        return head;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
