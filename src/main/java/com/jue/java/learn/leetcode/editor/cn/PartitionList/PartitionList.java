//给你一个链表和一个特定值 x ，请你对链表进行分隔，使得所有小于 x 的节点都出现在大于或等于 x 的节点之前。 
//
// 你应当保留两个分区中每个节点的初始相对位置。 
//
// 
//
// 示例： 
//
// 
//输入：head = 1->4->3->2->5->2, x = 3
//输出：1->2->2->4->3->5
// 
// Related Topics 链表 双指针 
// 👍 335 👎 0


package com.jue.java.learn.leetcode.editor.cn.PartitionList;

import com.jue.java.learn.tooffer.bean.ListNode;

/**
 * @author JUE
 * @number 86
 */
public class PartitionList {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.partition(new ListNode(new int[]{1, 4, 3, 2, 5, 2}), 3));
        System.out.println(solution.partition(new ListNode(new int[]{1}), 2));
        System.out.println(solution.partition(new ListNode(new int[]{1, 1}), 2));
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
    public ListNode partition(ListNode head, int x) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode prefix = null;
        ListNode prefixTemp = null;
        ListNode suffix = null;
        ListNode suffixTemp = null;
        ListNode current = head;
        ListNode next = null;
        while (current != null) {
            next = current.next;
            current.next = null;
            if (current.val < x) {
                if (prefix == null) {
                    prefix = prefixTemp = current;
                } else {
                    prefixTemp.next = current;
                    prefixTemp = current;
                }
            } else {
                if (suffix == null) {
                    suffix = suffixTemp = current;
                } else {
                    suffixTemp.next = current;
                    suffixTemp = current;
                }
            }
            current = next;
        }
        if (prefix == null) {
            return suffix;
        } else {
            prefixTemp.next = suffix;
            return prefix;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
