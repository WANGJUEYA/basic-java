//给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。 
//
// k 是一个正整数，它的值小于或等于链表的长度。 
//
// 如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。 
//
// 
//
// 示例： 
//
// 给你这个链表：1->2->3->4->5 
//
// 当 k = 2 时，应当返回: 2->1->4->3->5 
//
// 当 k = 3 时，应当返回: 3->2->1->4->5 
//
// 
//
// 说明： 
//
// 
// 你的算法只能使用常数的额外空间。 
// 你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。 
// 
// Related Topics 链表 
// 👍 621 👎 0


package com.jue.java.learntest.leetcode.editor.cn.ReverseNodesInKGroup;

import com.jue.java.learntest.tooffer.bean.ListNode;

/**
 * @author JUE
 * @number 25
 */
public class ReverseNodesInKGroup {
    public static void main(String[] args) {
        Solution solution = new Solution();

        ListNode listNode = new ListNode(new int[]{1, 2, 3, 4, 5});
        System.out.println(solution.reverseKGroup(listNode, 3));
        listNode = new ListNode(new int[]{1, 2});
        System.out.println(solution.reverseKGroup(listNode, 2));
    }
}

//leetcode submit region begin(Prohibit modification and deletion)

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null || k <= 1) {
            return head;
        }
        int count = 0;
        ListNode index = head;
        ListNode pre = null;
        ListNode current;

        while (index != null && ++count <= k) {
            index = index.next;
        }
        if (count < k) {
            return head;
        }
        count = 0;
        index = head;
        while (index != null && ++count <= k) {
            current = index;
            index = index.next;
            current.next = pre;
            pre = current;
        }
        head.next = reverseKGroup(index, k);
        return pre;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
