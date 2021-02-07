//给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。 
//
// 示例 1: 
//
// 输入: 1->1->2
//输出: 1->2
// 
//
// 示例 2: 
//
// 输入: 1->1->2->3->3
//输出: 1->2->3 
// Related Topics 链表


package com.jue.java.learn.leetcode.editor.cn.RemoveDuplicatesFromSortedList;


import com.jue.java.learn.tooffer.bean.ListNode;

/**
 * @author JUE
 * @number 83
 */
public class RemoveDuplicatesFromSortedList {
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
 * ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head != null) {
            head.next = deleteDuplicates(head.next);
            return head.next != null && head.val == head.next.val ? head.next : head;
        } else {
            return null;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
