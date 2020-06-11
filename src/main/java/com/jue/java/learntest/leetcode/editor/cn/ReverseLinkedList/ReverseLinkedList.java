//反转一个单链表。 
//
// 示例: 
//
// 输入: 1->2->3->4->5->NULL
//输出: 5->4->3->2->1->NULL 
//
// 进阶: 
//你可以迭代或递归地反转链表。你能否用两种方法解决这道题？ 
// Related Topics 链表


package com.jue.java.learntest.leetcode.editor.cn.ReverseLinkedList;

import com.jue.java.learntest.tooffer.bean.ListNode;

/**
 * @author JUE
 * @number 206
 */
public class ReverseLinkedList {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.reverseList(new ListNode(new int[]{1, 2, 3, 4, 5})));
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
    // 暴力
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode pre = null;
        ListNode current = head, suf = head;

        do {
            suf = suf.next;
            current.next = pre;
            pre = current;
            current = suf;
        } while (suf != null);

        return pre;
    }

}
//leetcode submit region end(Prohibit modification and deletion)
